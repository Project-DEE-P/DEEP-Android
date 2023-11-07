package com.example.app.presentation.screen.start.screen

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.app.di.HiltApplication
import com.example.app.presentation.navigation.Screen
import com.example.app.presentation.screen.start.viewmodel.StartViewModel
import com.example.app.presentation.screen.start.oauth.GoogleApiContract
import com.example.app.ui.components.button.DeepButton
import com.example.app.ui.components.button.DeepIconButton
import com.example.app.ui.theme.Blue
import com.example.app.ui.theme.Gray
import com.example.app.util.deepFontFamily
import com.example.deep_android.R
import com.example.domain.model.user.GoogleOauthRequestModel
import com.google.android.gms.common.api.ApiException


@Composable
fun StartScreen(
    navController: NavController,
//    activity: Activity,
    viewModel: StartViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    var googleToken: String

    val startForResult = rememberLauncherForActivityResult(GoogleApiContract()) { task ->
        try {
            val gsa = task?.getResult(ApiException::class.java)
            if (gsa != null) {
                // TODO : 성공시 처리 로직
                Log.d("SUCCESS", gsa.idToken!!)
                googleToken = gsa.idToken!!
                viewModel.googleOauthLogin(
                    googleOauthRequestModel = GoogleOauthRequestModel(googleToken)
                )
            } else {
                Log.d("FAIL", "gsa IS NULL")
            }
        } catch (e: ApiException) {
            e.printStackTrace()
        }
    }

//    if (HiltApplication.pref.autoLogin) {
//        navController.navigate(Screen.PutNfc.route)
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.image_deep),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.weight(1f))
        DeepButton(
            backgroundColor = Blue.DeepBlue,
            titleColor = Color.White,
            buttonTitle = "로그인",
            onClick = {
                Log.d(TAG, "I clicked login button")
                navController.navigate(Screen.Login.route)
//                navController.navigate(Screen.CardList.route)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        DeepIconButton(
            backgroundColor = Color.White,
            titleColor = Gray.Gray900,
            buttonTitle = "구글로 로그인",
            borderLine = true,
            iconResource = R.drawable.ic_google,
            onClick = {
                startForResult.launch(1)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "DEEP 유저가 아니라면?",
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Gray.Gray300
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier.clickable {
                    Log.d(TAG, "I clicked signup button")
                    navController.navigate(Screen.Signup.route)
                },
                text = "회원가입",
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Gray.Gray800
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

    /** Collect */
    LaunchedEffect(true) {
        viewModel.googleOauthState.collect {
            if (it.isSuccess) {
                navController.navigate(Screen.PutNfc.route)
            }
            if (it.error.isNotEmpty()) {
                Toast.makeText(context, "구글 로그인에 실패했어요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

const val TAG = "StartScreen"

//@Preview
//@Composable
//fun StartScreenPreview() {
//    val navController = rememberNavController()
////    StartScreen(navController = navController)
//}

/**
 * .SSH1 Google을 사용하여 config.json을 생성하면, 이 프로젝트와 연관된 Web OAuth2 키가 자동으로 생성됩니다.
 * 구글이 같은 이름의 프로젝트 3개를 만들었다는 것을 알게 되었습니다. (하나는 파이어베이스용, 하나는 웹용, 다른 하나는 확실하지 않음)
 *
 * 따라서 동일한 Android 프로젝트와 연결된 웹 클라이언트 ID를 가져옵니다.오 구글! */
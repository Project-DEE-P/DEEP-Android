package com.example.app.presentation.screen.start

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.navigation.Screen
import com.example.app.presentation.screen.start.oauth.GoogleOauth
import com.example.app.ui.components.button.DeepButton
import com.example.app.ui.components.button.DeepIconButton
import com.example.app.ui.theme.Blue
import com.example.app.ui.theme.Gray
import com.example.app.util.deepFontFamily
import com.example.deep_android.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException


@Composable
fun StartScreen(
    navController: NavController,
//    viewModel: StartViewModel
) {
    val context = LocalContext.current

    val googleAuthLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        runCatching {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            val account = task.getResult(ApiException::class.java)
//            viewModel.id.value = account.id
//            viewModel.email.value = account.email
        }.onSuccess {
//            viewModel.googleOauthLogin(
//                GoogleOauthRequestModel(
//                    viewModel.id.value.toString(),
//                    viewModel.email.value.toString()
//                )
//            )
            Log.d(TAG, "Google Oauth Success!!")
            Toast.makeText(context, "로그인 되었습니다", Toast.LENGTH_SHORT).show()
            navController.navigate(Screen.PutNfc.route)
        }.onFailure { e ->
            Log.e(TAG, "Google Oauth Failed.." + e.stackTraceToString())
            Toast.makeText(context, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
        }
    }

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
                navController.navigate(Screen.CardList.route)
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
                val googleOauth = GoogleOauth(context, googleAuthLauncher)
                googleOauth.requestGoogleLogin()
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
}

const val TAG = "StartScreen"

@Preview
@Composable
fun StartScreenPreview() {
    val navController = rememberNavController()
    StartScreen(navController = navController)
}
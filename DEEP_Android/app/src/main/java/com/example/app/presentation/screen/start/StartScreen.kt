package com.example.app.presentation.screen.start

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.navigation.Screen
import com.example.app.presentation.screen.start.oauth.GoogleOauth
import com.example.app.presentation.screen.start.oauth.content
import com.example.app.util.CLIENT_ID
import com.example.app.util.deepFontFamily
import com.example.deep_android.R
import com.example.domain.model.user.GoogleOauthRequestModel
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebView
import com.google.accompanist.web.WebViewState
import com.google.accompanist.web.rememberWebViewStateWithHTMLData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.common.api.internal.RegisterListenerMethod
import com.google.android.gms.tasks.Task
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception


@Composable
fun StartScreen(
    navController: NavController,
    viewModel: StartViewModel
) {
    val context = LocalContext.current

    val googleAuthLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        runCatching {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            val account = task.getResult(ApiException::class.java)
            viewModel.id.value = account.id
            viewModel.email.value = account.email
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
        Button(
            modifier = Modifier
                .height(49.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                // todo : 구글 로그인
                val googleOauth = GoogleOauth(context, googleAuthLauncher)
                googleOauth.requestGoogleLogin()
//                  navController.navigate(Screen.Login.route)
            },
        ) {
            Icon(
                modifier = Modifier.padding(end = 10.dp).size(20.dp),
                painter = painterResource
                    (id = R.drawable.ic_google),
                tint = Color.Unspecified,
                contentDescription = null
            )

            Text(
                text = "Google로 로그인",
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
}

const val TAG = "StartScreen"

//@Preview(showSystemUi = true)
//@Composable
//fun StartScreenPreview() {
//    val navController = rememberNavController()
//
////    StartScreen(
////        navController = navController)
//}


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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.util.CLIENT_ID
import com.example.app.util.deepFontFamily
import com.example.deep_android.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.common.api.internal.RegisterListenerMethod
import com.google.android.gms.tasks.Task
import java.lang.Exception

@Composable
fun StartScreen(
    activity: Activity
) {

    var account: GoogleSignInAccount
    var authCode: String

    val googleAuthLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        runCatching {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            account = task.getResult(ApiException::class.java)
//            authCode = account.serverAuthCode.toString()
//            Log.d(TAG, "Google Oauth Success!! $authCode")
        }.onSuccess {
            Log.d(TAG, "Google Oauth Success!!")
            Toast.makeText(activity, "로그인이 되었습니다", Toast.LENGTH_SHORT).show()
        }.onFailure { e ->
            Log.d(TAG, "Google Oauth Failed.." + e.stackTraceToString())
            Toast.makeText(activity, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
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
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                val googleOauth = GoogleOauth(activity, googleAuthLauncher)
                googleOauth.requestGoogleLogin()
            },
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                tint= Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "구글로 로그인하기",
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
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


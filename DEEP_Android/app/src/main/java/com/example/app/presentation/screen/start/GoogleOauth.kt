package com.example.app.presentation.screen.start

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import com.example.app.util.CLIENT_ID
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope

class GoogleOauth(
    private val activity: Activity,
    private val googleAuthLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>
) {

    private val googleSignInClient: GoogleSignInClient by lazy { getGoogleClient() }

    fun requestGoogleLogin() {
        googleSignInClient.signOut()
        val signInIntent = googleSignInClient.signInIntent
        googleAuthLauncher.launch(signInIntent)
    }

    private fun getGoogleClient(): GoogleSignInClient {
        val googleSignInOption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestServerAuthCode(CLIENT_ID)  // todo : Google Oauth Failed..com.google.android.gms.common.api.ApiException: 10:
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(activity, googleSignInOption)
    }
}


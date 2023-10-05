package com.example.app.presentation.screen.start

class GoogleOauth(
    private val activity: Activity,
    private val googleAuthLauncher: ActivityResultLauncher<Intent>
) {
    

    fun requestGoogleLogin() {
        googleSignInClient.signOut()
        val signInIntent = googleSignInClient.signInIntent
        googleAuthLauncher.launch(signInIntent)
    }

    private fun getGoogleClient(): GoogleSignInClient {
        val googleSignInOption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestScopes(Scope("https://www.googleapis.com/auth/pubsub"))
//            .requestServerAuthCode(GOOGLE_CLIENT_ID)
            .requestEmail() // 이메일도 요청할 수 있다.
            .build()

        return GoogleSignIn.getClient(activity, googleSignInOption)
    }
}

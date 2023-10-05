package com.example.app.presentation.screen.start

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
import com.example.app.util.deepFontFamily
import com.example.deep_android.R

@Composable
fun StartScreen(navController: NavController) {

    val googleSignInClient: GoogleSignInClient by lazy { getGoogleClient() }


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
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(16.dp),
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                tint= Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
//                modifier = Modifier.padding(vertical = 14.dp),
                text = "구글로 로그인하기",
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun StartScreenPreview() {
    val navController = rememberNavController()
    StartScreen(navController = navController)
}
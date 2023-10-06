package com.example.app.presentation.screen.login

import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.presentation.navigation.Screen
import com.example.app.util.deepFontFamily
import com.example.deep_android.R
import com.example.domain.model.user.LoginRequestModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun LoginScreen(
    navController: NavController,
) {
    val context = LocalContext.current

    var id by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }


    Column(
        modifier = Modifier
            .background(
                color = Color.White
            )
            .fillMaxSize()
    ) {
        IconButton(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = null
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 34.dp)
                .padding(horizontal = 16.dp),
            text = "로그인",
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        TextField(
            modifier = Modifier
                .padding(top = 60.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = id,
            onValueChange = { newText -> id = newText },
            placeholder = { Text(text = "아이디를 입력해주세요") },
            singleLine = true
        )
        TextField(
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = password,
            onValueChange = { newText -> password = newText },
            placeholder = { Text(text = "비밀번호를 입력해주세요") },
            singleLine = true
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .height(49.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue_500)),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                if (id.text.isNotEmpty() && password.text.isNotEmpty()) {
                    Log.d("LoginScreen", "LoginScreen: ${id.text}, ${password.text}")

//                    LaunchedEffect(Unit) {
//                        delay(10.seconds)
//                        if (viewModel.loginState.value == true) {
//                            navController.navigate(Screen.PutNfc.route)
//                        }
//                        if (viewModel.loginState.value == false) {
//                            Toast.makeText(context, "아이디나 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
//                        }
//                    }
                    //navController.navigate(Screen.PutNfc.route)
                } else if (id.text.isEmpty()) {
                    Toast.makeText(context, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                } else if (password.text.isEmpty()) {
                    Toast.makeText(context, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            },
        ) {
            Text(
                text = "로그인",
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
}
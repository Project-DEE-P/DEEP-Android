package com.example.app.presentation.screen.signup

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.ui.components.button.DeepButton
import com.example.app.ui.icon.BackArrow
import com.example.app.ui.theme.Blue
import com.example.app.ui.theme.Gray
import com.example.app.util.deepFontFamily
import com.example.deep_android.R


@Composable
fun SignupScreen(
    navController: NavController,
) {
    val context = LocalContext.current

    var id by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        BackArrow(navController = navController)
        Text(
            modifier = Modifier.padding(start = 24.dp, top = 34.dp),
            text = "회원가입",
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Gray.Gray900
        )
        TextField(
            modifier = Modifier
                .padding(top = 60.dp)
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            value = id,
            onValueChange = { newText -> id = newText },
            placeholder = { Text(text = "아이디를 입력해주세요") },
            singleLine = true
        )
        TextField(
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            value = password,
            onValueChange = { newText -> password = newText },
            placeholder = { Text(text = "비밀번호를 입력해주세요") },
            singleLine = true
        )
        Spacer(modifier = Modifier.weight(1f))
        DeepButton(
            modifier = Modifier.padding(horizontal = 8.dp),
            backgroundColor = Blue.DeepBlue,
            titleColor = Color.White,
            buttonTitle = "로그인",
            onClick = {  }
        )
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    SignupScreen(navController = navController)
}

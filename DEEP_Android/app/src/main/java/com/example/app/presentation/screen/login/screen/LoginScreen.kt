package com.example.app.presentation.screen.login.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.navigation.Screen
import com.example.app.presentation.screen.login.viewmodel.LoginViewModel
import com.example.app.ui.components.button.DeepButton
import com.example.app.ui.components.textfield.DeepTextField
import com.example.app.ui.icon.BackArrowButton
import com.example.app.ui.theme.Blue
import com.example.app.ui.theme.Gray
import com.example.app.util.deepFontFamily
import com.example.domain.model.user.LoginRequestModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
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
        BackArrowButton(navController = navController)
        Text(
            modifier = Modifier.padding(start = 24.dp, top = 35.dp),
            text = "로그인",
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Gray.Gray900
        )
        DeepTextField(
            modifier = Modifier.padding(top = 50.dp),
            value = id,
            label = "아이디",
            hint = "아이디를 입력해주세요",
            localFocusManager = LocalFocusManager,
            keyBoardType = KeyboardType.Text,
            onValueChange = { newText -> id = newText }
        )
        DeepTextField(
            modifier = Modifier.padding(top = 30.dp),
            value = password,
            label = "비밀번호",
            hint = "비밀번호를 입력해주세요",
            localFocusManager = LocalFocusManager,
            isLast = true,
            keyBoardType = KeyboardType.Password,
            onValueChange = { newText -> password = newText }
        )
        Spacer(modifier = Modifier.weight(1f))
        DeepButton(
            modifier = Modifier.padding(horizontal = 8.dp),
            backgroundColor = Blue.DeepBlue,
            titleColor = Color.White,
            buttonTitle = "로그인",
            onClick = {
                if (id.text.isNotEmpty() && password.text.isNotEmpty()) {
                    Log.d("LoginScreen", "LoginScreen: ${id.text}, ${password.text}")
                    viewModel.login(
                        LoginRequestModel(id.text, password.text)
                    )
                }
                if (id.text.isEmpty()) {
                    Toast.makeText(context, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                if (password.text.isEmpty()) {
                    Toast.makeText(context, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        )
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }

    /** Collect */
    LaunchedEffect(true) {
        viewModel.loginState.collect {
            if (it.isSuccess) {
                navController.navigate(Screen.PutNfc.route)
            }
            if (it.error.isNotEmpty()) {
                Toast.makeText(context, "아이디나 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}

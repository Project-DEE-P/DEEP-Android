package com.example.app.presentation.screen.signup.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.app.presentation.screen.signup.viewmodel.SignupViewModel
import com.example.app.ui.components.button.DeepButton
import com.example.app.ui.components.textfield.DeepTextField
import com.example.app.ui.icon.BackArrowButton
import com.example.app.ui.theme.Blue
import com.example.app.ui.theme.Gray
import com.example.app.util.deepFontFamily
import com.example.domain.model.user.SignupRequestModel


@Composable
fun SignupScreen(
    navController: NavController,
    viewModel: SignupViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    var name by remember { mutableStateOf(TextFieldValue("")) }
    var id by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordCheck by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        BackArrowButton(navController = navController)
        Text(
            modifier = Modifier.padding(start = 24.dp, top = 35.dp),
            text = "회원가입",
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Gray.Gray900
        )
        DeepTextField(
            modifier = Modifier.padding(top = 50.dp),
            value = name,
            label = "이름",
            hint = "이름을 입력해주세요",
            localFocusManager = LocalFocusManager,
            keyBoardType = KeyboardType.Text,
            onValueChange = { newText -> name = newText }
        )
        DeepTextField(
            modifier = Modifier.padding(top = 30.dp),
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
            keyBoardType = KeyboardType.Password,
            onValueChange = { newText -> password = newText }
        )
        DeepTextField(
            modifier = Modifier.padding(top = 30.dp),
            value = passwordCheck,
            label = "비밀번호 확인",
            hint = "비밀번호를 확인해주세요",
            localFocusManager = LocalFocusManager,
            keyBoardType = KeyboardType.Password,
            onValueChange = { newText -> passwordCheck = newText }
        )
        DeepTextField(
            modifier = Modifier.padding(top = 30.dp),
            value = email,
            label = "이메일",
            hint = "이메일을 입력해주세요",
            localFocusManager = LocalFocusManager,
            isLast = true,
            keyBoardType = KeyboardType.Email,
            onValueChange = { newText -> email = newText }
        )
        Spacer(modifier = Modifier.weight(1f))
        DeepButton(
            modifier = Modifier.padding(horizontal = 8.dp),
            backgroundColor = Blue.DeepBlue,
            titleColor = Color.White,
            buttonTitle = "회원가입",
            onClick = {
                if(name.text.isNotEmpty() && id.text.isNotEmpty() && password.text.isNotEmpty() && email.text.isNotEmpty()) {
                    viewModel.signup(
                        SignupRequestModel(
                            userId = id.text,
                            password = password.text,
                            name = name.text,
                            email = email.text
                        )
                    )
                } else {
                    Toast.makeText(context, "빈칸을 채워주세요", Toast.LENGTH_SHORT).show()
                }
            }
        )
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }

    /** Collect */
    LaunchedEffect(true) {
        viewModel.signupState.collect {
            if (it.isSuccess) {
                Toast.makeText(context, "회원가입한 아이디와\n비밀번호로 로그인해주세요", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.Login.route)
            }
            if (it.error.isNotEmpty()) {
                Toast.makeText(context, "회원가입에 실패했어요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Preview
@Composable
fun SignupScreenPreview() {
    val navController = rememberNavController()
    SignupScreen(navController = navController)
}

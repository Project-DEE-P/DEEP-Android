package com.example.app.presentation.screen.setting

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.di.HiltApplication
import com.example.app.presentation.navigation.Screen
import com.example.app.ui.icon.BackArrowButton
import com.example.app.ui.theme.Gray
import com.example.app.util.deepFontFamily
import com.example.deep_android.R

@Composable
fun SettingScreen(
    navController: NavController,
) {
    val context = LocalContext.current

    Column {
        BackArrowButton(navController = navController)
        Text(
            modifier = Modifier.padding(start = 24.dp, top = 10.dp),
            text = "설정",
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Gray.Gray900
        )
        CustomBox(modifier = Modifier.padding(top = 25.dp), title = "로그아웃") {
            HiltApplication.pref.deleteToken()
            navController.navigate(Screen.Start.route)
            Toast.makeText(context, "로그아웃 되었어요", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun CustomBox(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clickable(onClick = onClick)
            .clip(RoundedCornerShape(12.dp))
            .background(color = Gray.Gray50),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Gray.Gray600
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_mini),
                contentDescription = null
            )
        }
    }
}
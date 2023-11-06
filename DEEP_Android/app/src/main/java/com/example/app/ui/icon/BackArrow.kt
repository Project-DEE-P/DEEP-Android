package com.example.app.ui.icon

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.deep_android.R

@Composable
fun BackArrow(navController: NavController) {
    IconButton(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .size(24.dp),
        onClick = {
            navController.popBackStack()
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = null
        )
    }
}

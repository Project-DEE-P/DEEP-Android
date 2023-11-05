package com.example.app.ui.components.button

import android.content.Intent.ShortcutIconResource
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.Gray
import com.example.app.util.deepFontFamily

@Composable
fun DeepIconButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    titleColor: Color,
    buttonTitle: String,
    borderLine : Boolean = false,
    iconResource: Int,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .height(56.dp) // todo ?
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        border = if (borderLine) BorderStroke(1.dp, Gray.Gray100) else BorderStroke(0.dp, Gray.Line),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp
        ),
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = iconResource),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(14.dp))
        Text(
            text = buttonTitle,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = titleColor
        )
    }
}
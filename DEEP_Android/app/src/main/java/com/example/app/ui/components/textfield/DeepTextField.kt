package com.example.app.ui.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun DeepTextField(
    modifier: Modifier,
    value: TextFieldValue,
    label: String,
    onValueChange: (TextFieldValue) -> Unit
) {
    TextField(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        value = value,
        label = { Text(text = label) },
        onValueChange = onValueChange,
        placeholder = { Text(text = "비밀번호를 입력해주세요") },
        singleLine = true
    )
}
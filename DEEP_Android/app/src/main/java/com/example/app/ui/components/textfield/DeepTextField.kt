package com.example.app.ui.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun DeepTextField(
    modifier: Modifier,
    value: TextFieldValue,
    label: String,
    hint: String,
    localFocusManager: ProvidableCompositionLocal<FocusManager>,
    isLast: Boolean = false,
    onValueChange: (TextFieldValue) -> Unit
) {
    val focusManager = localFocusManager.current

    TextField(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        value = value,
        label = { Text(text = label) },
        onValueChange = onValueChange,
        placeholder = { Text(text = hint) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = if (isLast) ImeAction.Done else ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = { if (isLast) { focusManager.clearFocus() } },
            onNext = { if (!isLast) { focusManager.moveFocus(FocusDirection.Down) } }
        )
    )
}
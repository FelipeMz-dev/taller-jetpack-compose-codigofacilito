package com.mz_dev.tallerecommerce.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldBase(text: String, textValue: MutableState<String>){
    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        label = {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        singleLine = true
    )
}
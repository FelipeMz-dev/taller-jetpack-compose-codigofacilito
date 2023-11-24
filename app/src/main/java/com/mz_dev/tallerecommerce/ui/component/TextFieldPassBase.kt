package com.mz_dev.tallerecommerce.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.mz_dev.tallerecommerce.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPassBase(text: String, textValue: MutableState<String>){
    val passwordVisible = remember { mutableStateOf(false) }
    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            }) {
                if (passwordVisible.value) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_24),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }else {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        },
        label = {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        singleLine = true,
        visualTransformation = if (passwordVisible.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}
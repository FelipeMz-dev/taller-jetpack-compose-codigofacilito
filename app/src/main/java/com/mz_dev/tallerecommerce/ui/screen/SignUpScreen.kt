package com.mz_dev.tallerecommerce.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mz_dev.tallerecommerce.ui.component.ButtonBase
import com.mz_dev.tallerecommerce.ui.component.LogoApp
import com.mz_dev.tallerecommerce.ui.component.TextClickBase
import com.mz_dev.tallerecommerce.ui.component.TextFieldBase
import com.mz_dev.tallerecommerce.ui.component.TextFieldPassBase
import com.mz_dev.tallerecommerce.ui.navigation.AppScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                LogoApp()
                Spacer(modifier = Modifier.size(20.dp))
                TextFieldBase(text = "name", textValue = nameValue)
                Spacer(modifier = Modifier.size(10.dp))
                TextFieldBase(text = "Email", textValue = emailValue)
                Spacer(modifier = Modifier.size(10.dp))
                TextFieldBase(text = "Phone", textValue = phoneValue)
                Spacer(modifier = Modifier.size(10.dp))
                TextFieldPassBase(text = "Password", textValue = passwordValue)
                Spacer(modifier = Modifier.size(10.dp))
                TextFieldPassBase(text = "Confirm Password", textValue = confirmPasswordValue)
                Spacer(modifier = Modifier.size(20.dp))
                ButtonBase(text = "Sign Up") {
                    nameValue.value = ""
                    emailValue.value = ""
                    phoneValue.value = ""
                    passwordValue.value = ""
                    confirmPasswordValue.value = ""
                }
                Spacer(modifier = Modifier.size(20.dp))
                TextClickBase(text = "Login") {
                    navController.popBackStack()
                    navController.navigate(AppScreen.LoginScreen.route)
                }
            }
        }
    }
}
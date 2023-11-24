package com.mz_dev.tallerecommerce.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mz_dev.tallerecommerce.ui.component.ButtonBase
import com.mz_dev.tallerecommerce.ui.component.LogoApp
import com.mz_dev.tallerecommerce.ui.component.TextClickBase
import com.mz_dev.tallerecommerce.ui.component.TextFieldBase
import com.mz_dev.tallerecommerce.ui.component.TextFieldPassBase
import com.mz_dev.tallerecommerce.ui.navigation.AppScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

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
                TextFieldBase(text = "Email", textValue = emailValue)
                Spacer(modifier = Modifier.size(10.dp))
                TextFieldPassBase(text = "Password", textValue = passwordValue)
                Spacer(modifier = Modifier.size(20.dp))
                ButtonBase(text = "Login") {
                    navController.popBackStack()
                    navController.navigate(AppScreen.HomeScreen.route)
                }
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = "Don't have an account?",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(10.dp))
                TextClickBase(text = "Sign Up") {
                    navController.popBackStack()
                    navController.navigate(AppScreen.SignUpScreen.route)
                }
            }
        }
    }
}
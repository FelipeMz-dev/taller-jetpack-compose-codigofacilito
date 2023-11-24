package com.mz_dev.tallerecommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mz_dev.tallerecommerce.ui.navigation.AppNavigation
import com.mz_dev.tallerecommerce.ui.theme.TallerEcommerceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val initialDarkTheme = isSystemInDarkTheme()
            val stateTheme = remember { mutableStateOf(initialDarkTheme) }
            TallerEcommerceTheme(darkTheme = stateTheme.value) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation {
                        stateTheme.value = !stateTheme.value
                    }
                }
            }
        }
    }
}

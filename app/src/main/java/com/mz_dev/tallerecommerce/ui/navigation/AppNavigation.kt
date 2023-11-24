package com.mz_dev.tallerecommerce.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mz_dev.tallerecommerce.ui.screen.DetailsScreen
import com.mz_dev.tallerecommerce.ui.screen.HomeScreen
import com.mz_dev.tallerecommerce.ui.screen.LoginScreen
import com.mz_dev.tallerecommerce.ui.screen.SignUpScreen

@Composable
fun AppNavigation(changeTheme: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.LoginScreen.route
    ) {
        composable(AppScreen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(AppScreen.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(AppScreen.HomeScreen.route) {
            HomeScreen(navController, changeTheme)
        }
        composable("${AppScreen.DetailsScreen.route}/{index}", arguments = listOf(navArgument("index"){type=
            NavType.IntType})){
            DetailsScreen(navController,it.arguments?.getInt("index")?:0)
        }
    }
}
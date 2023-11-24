package com.mz_dev.tallerecommerce.ui.screen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mz_dev.tallerecommerce.R
import com.mz_dev.tallerecommerce.ui.component.BottomBarApp
import com.mz_dev.tallerecommerce.ui.component.TopBarApp
import com.mz_dev.tallerecommerce.ui.fragment.CategoriesFragment
import com.mz_dev.tallerecommerce.ui.fragment.CompaniesFragment
import com.mz_dev.tallerecommerce.ui.fragment.OrderCardFragment
import com.mz_dev.tallerecommerce.ui.fragment.ProfileFragment
import com.mz_dev.tallerecommerce.ui.navigation.AppScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, changeTheme: () -> Unit) {
    val navItems = Section.values().toList()
    val currentSection = remember { mutableStateOf(Section.Companies) }
    Scaffold(
        modifier = Modifier.padding(12.dp),
        topBar = {
            Surface(
                color = MaterialTheme.colorScheme.background,
                shadowElevation = 8.dp
            ) {
                Crossfade(
                    targetState = currentSection.value,
                    label = ""
                ) { section ->
                    when (section) {
                        Section.Companies -> {
                            TopBarApp(
                                title = "Restaurants",
                                description = "Order your food to take",
                                idIcon = R.drawable.baseline_lightbulb_24
                            ) { changeTheme() }
                        }

                        Section.Explore -> {
                            TopBarApp(
                                title = "Categories",
                                description = "Main categories",
                                idIcon = R.drawable.baseline_search_24
                            ) {}
                        }

                        Section.Orders -> {
                            TopBarApp(
                                title = "Cart",
                                description = "Purchased products",
                                idIcon = R.drawable.baseline_filter_list_24
                            ) {}
                        }

                        Section.Profile -> {
                            TopBarApp(
                                title = "Profile",
                                description = "Personal data",
                                idIcon = R.drawable.baseline_logout_24
                            ) {
                                navController.popBackStack()
                                navController.navigate(AppScreen.LoginScreen.route)
                            }
                        }

                    }
                }
            }
        },
        bottomBar = {
            BottomBarApp(
                items = navItems,
                currentSection = currentSection.value,
                onSectionSelected = { currentSection.value = it }
            )
        }
    ) { paddingValues ->
        Crossfade(
            targetState = currentSection.value,
            label = "",
            modifier = Modifier.padding(paddingValues)
        ) { section ->
            when (section) {
                Section.Companies -> CompaniesFragment(navController = navController)
                Section.Explore -> CategoriesFragment(navController = navController)
                Section.Orders -> OrderCardFragment(navController = navController)
                Section.Profile -> ProfileFragment(navController = navController)
            }

        }
    }
}

enum class Section(val icon: Int) {
    Companies(R.drawable.baseline_home_24),
    Explore(R.drawable.baseline_search_24),
    Orders(R.drawable.baseline_shopping_cart_24),
    Profile(R.drawable.baseline_person_24)
}
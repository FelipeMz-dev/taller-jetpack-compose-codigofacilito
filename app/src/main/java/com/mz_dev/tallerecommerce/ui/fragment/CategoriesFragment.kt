package com.mz_dev.tallerecommerce.ui.fragment

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mz_dev.tallerecommerce.model.Category
import com.mz_dev.tallerecommerce.ui.component.card.CategoryCard
import com.mz_dev.tallerecommerce.ui.component.card.TagCard

@Composable
fun CategoriesFragment(navController: NavController) {
    val categories = Category().getCategories()
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(categories) {
            CategoryCard(category = it){}
        }
    }
}
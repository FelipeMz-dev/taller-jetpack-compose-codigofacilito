package com.mz_dev.tallerecommerce.ui.fragment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mz_dev.tallerecommerce.model.Order
import com.mz_dev.tallerecommerce.ui.component.card.CompanyCard
import com.mz_dev.tallerecommerce.ui.component.card.ProductCard

@Composable
fun OrderCardFragment(navController: NavController) {
    val orders = Order().getOrders()
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            items(orders) {
                ProductCard(
                    title = it.title,
                    subtitle = "${it.count} Articles\n MXN ${it.total}\n ${it.direction}",
                    idImage = it.image,
                    idIcon = Icons.Default.Close
                ) {

                }
            }
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
        ) {
            Text(
                text = "BUY",
                style = MaterialTheme.typography.body1
            )
        }

    }
}
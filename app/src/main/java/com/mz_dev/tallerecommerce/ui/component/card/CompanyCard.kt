package com.mz_dev.tallerecommerce.ui.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mz_dev.tallerecommerce.model.Company

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyCard(company: Company, onItemClick: (company: Company) -> Unit) {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp),
        onClick = { onItemClick(company) }
    ) {
        Column {
            val image: Painter = painterResource(id = company.image)
            Image(
                painter = image, contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = company.name,
                        style = MaterialTheme.typography.titleLarge)
                    Text(text = "Delivery price: ${ company.deliveryPrice } . ${ company.deliveryTime}",
                        style = MaterialTheme.typography.bodyMedium)
                }
                TagCard(tag = company.rating)
            }
        }

    }
}
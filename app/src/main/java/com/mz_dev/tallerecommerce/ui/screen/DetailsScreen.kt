package com.mz_dev.tallerecommerce.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mz_dev.tallerecommerce.model.Company
import com.mz_dev.tallerecommerce.ui.component.card.ProductCard
import com.mz_dev.tallerecommerce.ui.component.card.TagCard

@Composable
fun DetailsScreen(navController:NavController, index:Int) {
    val company = Company().getCompanies()[index]
    Scaffold(backgroundColor = MaterialTheme.colorScheme.background) { padding ->

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .padding(paddingValues = padding)
        ){
            item{
                val image: Painter = painterResource(id = company.image)
                Image(
                    painter = image, contentDescription = "",
                    modifier = Modifier
                        .height(350.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                CompanyInfo(company)
            }

            items(company.products.size){index->
                val company =company.products[index]
                ProductCard(
                    title = company.name,
                    subtitle = company.price.toString(),
                    idImage =company.image ,
                    idIcon = Icons.Default.Add,
                    ) {}
            }
        }

    }

}

@Composable
fun CompanyInfo(company:Company){
    Column(modifier = Modifier.padding(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text =company.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            TagCard(company.rating)
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text =company.description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
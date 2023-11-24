package com.mz_dev.tallerecommerce.ui.fragment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mz_dev.tallerecommerce.R
import com.mz_dev.tallerecommerce.model.Category
import com.mz_dev.tallerecommerce.model.Company
import com.mz_dev.tallerecommerce.ui.component.card.CompanyCard
import com.mz_dev.tallerecommerce.ui.component.card.TagCard
import com.mz_dev.tallerecommerce.ui.navigation.AppScreen

@Composable
fun CompaniesFragment(navController: NavController) {
    val companies = Company().getCompanies()
    LazyColumn {
        item {
            Text(text = "Now. Maria Paula #1234",
                modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Slides()
            Spacer(modifier = Modifier.padding(10.dp))
            Categories()
        }

        items(companies) { company ->
            CompanyCard(company = company){
                navController.navigate("${AppScreen.DetailsScreen.route}/${company.id}")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Slides() {
    val images = listOf(
        R.drawable.alitas,
        R.drawable.chillis,
        R.drawable.mariscos,
        R.drawable.chinas,
        R.drawable.burgerking
    )
    val pagerState = rememberPagerState(pageCount = { images.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.height(150.dp)
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Categories() {
    val categories = Category().getCategories()
    Column {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                ) {
                    append("¿Are you looking for something else?")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 22.sp
                    )
                ) {
                    append("Browse categories")
                }
            },
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
            )
        Spacer(modifier = Modifier.padding(10.dp))
        LazyRow{
            items(categories) {
                TagCard(tag = it.category)
            }
        }
    }
}
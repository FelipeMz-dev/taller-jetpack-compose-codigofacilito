package com.mz_dev.tallerecommerce.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mz_dev.tallerecommerce.R

@Composable
fun LogoApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.applogo),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Delivery", fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 5.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
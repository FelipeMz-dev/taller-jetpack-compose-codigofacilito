package com.mz_dev.tallerecommerce.ui.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProductCard(
    title: String,
    subtitle: String,
    idImage: Int,
    idIcon: ImageVector,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(5.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 5.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image: Painter = painterResource(id = idImage)
                Image(
                    painter = image, contentDescription = null,
                    modifier = Modifier
                        .size(100.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            TagCard(icon = idIcon)
        }
    }
}
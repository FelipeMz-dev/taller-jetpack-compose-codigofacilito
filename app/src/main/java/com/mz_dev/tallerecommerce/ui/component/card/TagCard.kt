package com.mz_dev.tallerecommerce.ui.component.card

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun TagCard(tag: String = "", icon: ImageVector = Icons.Default.Add) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(3.dp)
    ) {
        if (tag.isNotEmpty()) {
            Text(
                text = tag,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                color = MaterialTheme.colorScheme.onPrimary
            )
        } else {
            Icon(
                icon,
                tint = MaterialTheme.colorScheme.onPrimary,
                contentDescription = "",
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}
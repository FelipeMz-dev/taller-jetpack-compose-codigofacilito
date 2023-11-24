package com.mz_dev.tallerecommerce.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mz_dev.tallerecommerce.ui.screen.Section

@Composable
fun BottomBarApp(
    items: List<Section>,
    currentSection: Section,
    onSectionSelected: (Section) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.surface
    ) {
        items.forEach { section ->
            val selected = section == currentSection
            BottomNavigationItem(
                selected = selected,
                onClick = { onSectionSelected(section) },
                icon = {
                    Icon(
                        painter = painterResource(id = section.icon),
                        contentDescription = section.name,
                        modifier = Modifier.size(24.dp)
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
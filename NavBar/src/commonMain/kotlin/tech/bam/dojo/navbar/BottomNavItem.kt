package tech.bam.dojo.navbar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
fun RowScope.BottomNavItem(
    tab: Tab,
    navigator: TabNavigator,
    modifier: Modifier = Modifier,
) {
    val isSelected = navigator.current == tab
    NavigationBarItem(
        selected = isSelected,
        onClick = {
            navigator.current = tab
        },
        icon = {
            tab.options.icon?.let { it: Painter ->
                Row(
                    modifier = Modifier.animateContentSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(painter = it, contentDescription = null)
                    if (isSelected) {
                        Text(
                            tab.options.title,
                            color = FreetimelanceTrackerColors.white,
                        )
                    }
                }
            }
        },
        modifier = modifier,
        label = null,
        alwaysShowLabel = false,
        colors =
            NavigationBarItemDefaults.colors(
                selectedIconColor = FreetimelanceTrackerColors.white,
                selectedTextColor = FreetimelanceTrackerColors.white,
                indicatorColor = FreetimelanceTrackerColors.purpleDark,
                unselectedIconColor = FreetimelanceTrackerColors.purpleDark,
                unselectedTextColor = FreetimelanceTrackerColors.purpleDark,
                disabledIconColor = FreetimelanceTrackerColors.secondary,
                disabledTextColor = FreetimelanceTrackerColors.secondary,
        ),
    )
}

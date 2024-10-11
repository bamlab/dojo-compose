package tech.bam.dojo.navbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
fun RowScope.BottomNavItem(
    tab: Tab,
    navigator: TabNavigator,
    modifier: Modifier = Modifier,
) {
    NavigationBarItem(
        selected = navigator.current == tab,
        onClick = {
            navigator.current = tab
        },
        icon = {
            tab.options.icon?.let { it: Painter ->
                Icon(painter = it, contentDescription = null)
            }
        },
        modifier = modifier,
        label = {
            Text(
                tab.options.title,
            )
        },
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

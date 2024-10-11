package tech.bam.dojo.navbar

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator

@Composable
fun BottomNavItem(
    tab: Tab,
    navigator: TabNavigator,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = {
            navigator.current = tab
        },
        modifier = modifier,
    ) {
        Text(text = tab.options.title, style = MaterialTheme.typography.bodyLarge)
    }
}

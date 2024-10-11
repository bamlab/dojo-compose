package tech.bam.dojo.navbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator

class NavBarScreen : Screen {
    override val key = "Nav Bar"

    @Composable
    override fun Content() {
        NavBarView()
    }
}

@Composable
fun NavBarView() {
    TabNavigator(HomeTab) { navigator ->
        Scaffold(
            content = { CurrentTab() },
            bottomBar = {
                Row {
                    BottomNavItem(HomeTab, navigator, Modifier.padding(16.dp))
                    BottomNavItem(AnalyzeTab, navigator, Modifier.padding(16.dp))
                    BottomNavItem(TasksTab, navigator, Modifier.padding(16.dp))
                    BottomNavItem(ProfileTab, navigator, Modifier.padding(16.dp))
                }
            },
        )
    }
}

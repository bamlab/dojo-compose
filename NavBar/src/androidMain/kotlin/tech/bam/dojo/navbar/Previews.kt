package tech.bam.dojo.navbar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Preview
@Composable
fun NavBarPreview() {
    TabNavigator(HomeTab) { navigator ->
        Scaffold(
            content = { CurrentTab() },
            bottomBar = {
                NavigationBar(
                    modifier =
                        Modifier.clip(
                            RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                            ),
                        ),
                    containerColor = FreetimelanceTrackerColors.purpleLight.copy(alpha = 0.4f),
                    contentColor = FreetimelanceTrackerColors.purpleDark,
                ) {
                    BottomNavItem(HomeTab, navigator)
                    BottomNavItem(AnalyzeTab, navigator)
                    BottomNavItem(TasksTab, navigator)
                    BottomNavItem(ProfileTab, navigator)
                }
            },
        )
    }
}

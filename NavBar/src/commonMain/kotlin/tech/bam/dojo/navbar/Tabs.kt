package tech.bam.dojo.navbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Text("Home tab")
    }
}

object AnalyzeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Analytics)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Analyze",
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Text("Analyze tab")
    }
}

object TasksTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Task)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Tasks",
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Text("Tasks tab")
    }
}

object ProfileTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Person)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Profile",
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Text("Profile tab")
    }
}

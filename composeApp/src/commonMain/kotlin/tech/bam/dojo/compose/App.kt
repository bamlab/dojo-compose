package tech.bam.dojo.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val firstScreenToShow = screenList.last() // To see the current dojo first
    MaterialTheme {
        Navigator(
            listOf(
                HomeScreen(),
                firstScreenToShow,
            ),
        )
    }
}

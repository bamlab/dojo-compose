package tech.bam.dojo.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.bam.dojo.onpresseffect.OnPressScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainContent()
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.HOME,
        modifier = Modifier.fillMaxSize(),
    ) {
        composable(Destination.HOME) {
            Column(
                modifier = Modifier.fillMaxSize().padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement =
                    Arrangement.spacedBy(
                        16.dp,
                        Alignment.CenterVertically,
                    ),
            ) {
                val greeting = remember { Greeting().greet() }
                Text(greeting, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.padding(16.dp))
                // DOJO: STEP 2 - Add a NavButton to navigate to the current dojo screen
                NavButton(Destination.ON_PRESS_EFFECT, navController)
            }
        }
        // DOJO: STEP 3 - Add deeplinkedComposable to the current dojo screen
        deeplinkedComposable(Destination.ON_PRESS_EFFECT) {
            OnPressScreen()
        }
    }
}

package tech.bam.dojo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.bam.dojo.onpresseffect.OnPressScreen
import tech.bamlab.dojo.revealanimation.AnimatedVisibilityScreen
import tech.bamlab.dojo.revealanimation.RevealAnimationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Destination.HOME,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(Destination.HOME) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        )
                    ) {
                        // DOJO: STEP 3 - Add a NavButton to navigate to the current dojo screen
                        NavButton(Destination.ON_PRESS_EFFECT, navController)
                        NavButton(Destination.REVEAL_ANIMATION, navController)
                        NavButton(Destination.ANIMATED_VISIBILITY, navController)
                    }
                }
                // DOJO: STEP 4 - Add deeplinkedComposable to the current dojo screen
                deeplinkedComposable(Destination.ON_PRESS_EFFECT) {
                    OnPressScreen()
                }
                deeplinkedComposable(Destination.REVEAL_ANIMATION) {
                    RevealAnimationScreen()
                }
                deeplinkedComposable(Destination.ANIMATED_VISIBILITY) {
                    AnimatedVisibilityScreen()
                }
            }
        }
    }
}

private object Destination {
    const val HOME = "HOME"

    // DOJO: STEP 2 - Add a new destination for the current Dojo screen
    const val ON_PRESS_EFFECT = "ON_PRESS_EFFECT"
    const val REVEAL_ANIMATION = "REVEAL_ANIMATION"
    const val ANIMATED_VISIBILITY = "ANIMATED_VISIBILITY"
}

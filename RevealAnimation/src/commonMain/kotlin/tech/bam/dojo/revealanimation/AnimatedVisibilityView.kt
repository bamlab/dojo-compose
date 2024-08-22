package tech.bam.dojo.revealanimation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityView() {
    // Create a MutableTransitionState<Boolean> for the AnimatedVisibility.
    val visible =
        remember {
            MutableTransitionState(false).apply {
                // Start the animation immediately.
                targetState = true
            }
        }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        AnimateRevealVisibility(visible) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier =
                    Modifier
                        .size(150.dp)
                        .clickable(
                            remember { MutableInteractionSource() },
                            null,
                        ) {
                            visible.targetState = !visible.currentState
                        },
            )
        }
        AnimateRevealContent(visible) { visible ->
            Icon(
                imageVector = if (visible) Icons.Default.AccountCircle else Icons.Default.Clear,
                contentDescription = null,
                modifier =
                    Modifier
                        .size(150.dp),
            )
        }
        Button(
            onClick =
                {
                    visible.targetState = !visible.currentState
                },
        ) {
            Text(
                "Click here to change state",
                Modifier.padding(16.dp),
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateRevealContent(
    visible: MutableTransitionState<Boolean> =
        remember {
            MutableTransitionState(false).apply {
                // Start the animation immediately.
                targetState = true
            }
        },
    content: @Composable (Boolean) -> Unit,
) {
    AnimatedContent(
        targetState = visible.currentState,
        transitionSpec = {
            if (this.targetState) {
                // In of the visible element, out of the other
                scaleIn(spring(stiffness = Spring.StiffnessHigh)) with scaleOut(spring(stiffness = Spring.StiffnessHigh))
            } else {
                // In of the placeholder element, out of the other
                scaleIn(spring(stiffness = Spring.StiffnessLow)) with scaleOut(spring(stiffness = Spring.StiffnessLow))
            }
        },
    ) { elemVisible ->
        content(elemVisible)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateRevealVisibility(
    visible: MutableTransitionState<Boolean> =
        remember {
            MutableTransitionState(false).apply {
                // Start the animation immediately.
                targetState = true
            }
        },
    content: @Composable () -> Unit,
) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visibleState = visible,
        enter =
            slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } +
                expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top,
                ) +
                fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f,
                ) + scaleIn(),
        exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(),
    ) {
        content()
    }
}

package tech.bamlab.dojo.revealanimation

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityScreen() {
    // Create a MutableTransitionState<Boolean> for the AnimatedVisibility.
    val visible = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        AnimateRevealVisibility(visible) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clickable(
                        remember { MutableInteractionSource() }, null
                    ) {
                        visible.targetState = !visible.currentState
                    }

            )
        }
        AnimateRevealContent(visible) { visible ->
            Icon(
                imageVector = if (visible) Icons.Default.AccountCircle else Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)

            )
        }
        Text(
            "toto",
            Modifier
                .clickable {
                    visible.targetState = !visible.currentState
                }
                .padding(16.dp)
        )


    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateRevealContent(
    visible: MutableTransitionState<Boolean> = remember {
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
        }
    ) { elemVisible ->
        content(elemVisible)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateRevealVisibility(
    visible: MutableTransitionState<Boolean> = remember {
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
        enter = slideInVertically {
            // Slide in from 40 dp from the top.
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            // Expand from the top.
            expandFrom = Alignment.Top
        ) + fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ) + scaleIn(),
        exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut()
    ) {
        content()
    }

}

@Preview(showBackground = true)
@Composable
private fun AnimatedVisibilityScreenPreview() {
    AnimatedVisibilityScreen()
}

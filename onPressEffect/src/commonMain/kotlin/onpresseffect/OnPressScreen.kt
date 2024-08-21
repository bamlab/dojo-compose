package tech.bam.dojo.onpresseffect

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest

@Composable
fun OnPressScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        FidgetCard(
            Modifier
                .fillMaxWidth(0.66f)
                .fillMaxHeight(0.2f),
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FidgetCard(modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    Card(
        onClick = {},
        modifier = modifier.addPressEffect(interactionSource),
        shape = RoundedCornerShape(8.dp),
        interactionSource = interactionSource,
    ) {
        FidgetCardContent()
    }
}

private fun Modifier.addPressEffect(interactionSource: MutableInteractionSource) =
    composed {
        var width by remember { mutableStateOf(0) }
        var height by remember { mutableStateOf(0) }
        val (transformAngleX, setTransformAngleX) = remember { mutableStateOf(0f) }
        val (transformAngleY, setTransformAngleY) = remember { mutableStateOf(0f) }

        val animatedTransformAngleX by animateFloatAsState(transformAngleX)
        val animatedTransformAngleY by animateFloatAsState(transformAngleY)

        fun updateTransformation(
            newTransformAngleX: Float,
            newTransformAngleY: Float,
        ) {
            setTransformAngleX(newTransformAngleX)
            setTransformAngleY(newTransformAngleY)
        }
        LaunchedEffect(this) {
            interactionSource.interactions.collectLatest { interaction ->
                when (interaction) {
                    is PressInteraction.Press -> {
                        calcTransformationFromInput(
                            centroid = interaction.pressPosition,
                            width = width.toFloat(),
                            height = height.toFloat(),
                        ).let {
                            updateTransformation(it.first, it.second)
                        }
                    }

                    is PressInteraction.Release, is PressInteraction.Cancel ->
                        updateTransformation(
                            0f,
                            0f,
                        )
                }
            }
        }

        this
            .onGloballyPositioned { layoutCoordinates ->
                height = layoutCoordinates.size.height
                width = layoutCoordinates.size.width
            }.graphicsLayer {
                // translationX = -animatedTransformAngleY * 5
                // translationY = animatedTransformAngleX * 5
                rotationX = animatedTransformAngleX
                rotationY = animatedTransformAngleY
            }.shadow(
                elevation =
                    with(LocalDensity.current) {
                        (animatedTransformAngleX.toDp() * 4 + 10.dp).coerceIn(
                            2.dp,
                            20.dp,
                        )
                    },
                shape = RoundedCornerShape(8.dp),
            )
    }

package tech.bam.dojo.onpresseffect

import android.util.Log
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import java.lang.Float

@Composable
fun OnPressScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val componentSize = remember { mutableStateOf(IntSize(0, 0)) }
        val tapInput: MutableState<Offset> = remember { mutableStateOf(Offset(0f, 0f)) }

        val animatedTap by animateOffsetAsState(tapInput.value)

        FidgetCard(
            Modifier
                .fillMaxWidth(0.66f)
                .fillMaxHeight(0.2f)
                .onGloballyPositioned { layoutCoordinates ->
                    componentSize.value = layoutCoordinates.size
                }
                .pointerInput(null) {
                    this.detectTapGestures { offset ->
                        tapInput.value = offset
                    }
                }
                .graphicsLayer {
                    val height = componentSize.value.height.toFloat()
                    val width = componentSize.value.width.toFloat()
                    val transformation = calcTransformationFromInput(
                        animatedTap,
                        width,
                        height
                    )
                    this.rotationX = transformation.first
                    this.rotationY = transformation.second
                }
        )
    }
}

@Composable
fun FidgetCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        FidgetCardContent()
    }
}

@Preview(showBackground = true)
@Composable
fun OnPressScreenPreview() {
    OnPressScreen()
}

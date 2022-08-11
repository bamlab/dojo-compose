package tech.bamlab.dojo.revealanimation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RevealAnimationScreen() {

    var resetEffect by rememberSaveable {
        mutableStateOf("", neverEqualPolicy())
    }
    var rotateX by rememberSaveable { mutableStateOf(false) }
    var rotateY by rememberSaveable { mutableStateOf(false) }
    var rotateZ by rememberSaveable { mutableStateOf(false) }
    var scale by rememberSaveable { mutableStateOf(true) }
    var alpha by rememberSaveable { mutableStateOf(false) }


    var tween by rememberSaveable { mutableStateOf(false) }
    var durationMillis by rememberSaveable { mutableStateOf(1000) }
    var delayMillis by rememberSaveable { mutableStateOf(0) }
    var dampingRatio by rememberSaveable { mutableStateOf(0.5f) } // 0 to 1
    var stiffness by rememberSaveable { mutableStateOf(1500f) } // 0 to 5000
    val animatedSpec: AnimationSpec<Float> =
        remember(tween, durationMillis, delayMillis, dampingRatio, stiffness) {
            if (tween) {
                tween(
                    durationMillis = durationMillis,
                    delayMillis = delayMillis,
                )
            } else {
                spring(
                    dampingRatio = dampingRatio,
                    stiffness = stiffness,
                )
            }
        }

    var baseModifier = Modifier
        .size(150.dp)
        .clickable(
            remember { MutableInteractionSource() }, null
        ) { resetEffect += "a" }
    if (scale) baseModifier =
        baseModifier.scaleRevealAnimation(resetEffect = resetEffect, animation = animatedSpec)
    if (rotateX) baseModifier =
        baseModifier.rotateXRevealAnimation(resetEffect = resetEffect, animation = animatedSpec)
    if (rotateY) baseModifier =
        baseModifier.rotateYRevealAnimation(resetEffect = resetEffect, animation = animatedSpec)
    if (rotateZ) baseModifier =
        baseModifier.rotateZRevealAnimation(resetEffect = resetEffect, animation = animatedSpec)
    if (alpha) baseModifier =
        baseModifier.alphaRevealAnimation(resetEffect = resetEffect, animation = animatedSpec)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = baseModifier

        )
        Text("toto")
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                Checkbox(checked = rotateZ, onCheckedChange = { rotateZ = !rotateZ })
                Text("rotateZ")
            }
            item {
                Checkbox(checked = scale, onCheckedChange = { scale = !scale })
                Text("scale")
            }
            item {
                Checkbox(checked = rotateX, onCheckedChange = { rotateX = !rotateX })
                Text("rotateX")
            }
            item {
                Checkbox(checked = rotateY, onCheckedChange = { rotateY = !rotateY })
                Text("rotateY")
            }
            item {
                Checkbox(checked = alpha, onCheckedChange = { alpha = !alpha })
                Text("alpha")
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = tween, onCheckedChange = { tween = !tween })
            Text("tween")
        }

        if (tween) {
            Text(text = "duration 10 - 5000 -> $durationMillis")
            Slider(
                value = durationMillis.toFloat(),
                onValueChange = { durationMillis = it.toInt() },
                valueRange = 10f..5000f,
                steps = 200
            )
            Text(text = "delay 0 - 1000 -> $delayMillis")
            Slider(
                value = delayMillis.toFloat(),
                onValueChange = { delayMillis = it.toInt() },
                valueRange = 0f..1000f,
                steps = 200
            )
        } else {
            Text(text = "damping 0 - 1 -> $dampingRatio")
            Slider(
                value = dampingRatio,
                onValueChange = { dampingRatio = it },
                valueRange = 0f..1f,
                steps = 200
            )
            Text(text = "stiffness 0 - 5000 -> $stiffness")
            Slider(
                value = stiffness,
                onValueChange = { stiffness = it },
                valueRange = 0f..5000f,
                steps = 200
            )
        }

    }


}

private fun Modifier.alphaRevealAnimation(resetEffect: Any?, animation: AnimationSpec<Float>) =
    this.genericRevealAnimation(
        animationSpec = animation,
        targetValue = 1f,
        resetEffect = resetEffect
    ) { scope, animatedValue ->
        scope.alpha = animatedValue
    }


private fun Modifier.scaleRevealAnimation(resetEffect: Any?, animation: AnimationSpec<Float>) =
    this.genericRevealAnimation(
        animationSpec = animation,
        targetValue = 1f,
        resetEffect = resetEffect
    ) { scope, animatedValue ->
        scope.scaleX = animatedValue
        scope.scaleY = animatedValue
    }

private fun Modifier.rotateZRevealAnimation(resetEffect: Any?, animation: AnimationSpec<Float>) =
    this.genericRevealAnimation(
        animationSpec = animation,
        targetValue = 360 * 4f,
        resetEffect = resetEffect
    ) { scope, animatedValue ->
        scope.rotationZ = animatedValue
    }

private fun Modifier.rotateXRevealAnimation(resetEffect: Any?, animation: AnimationSpec<Float>) =
    this.genericRevealAnimation(
        animationSpec = animation,
        targetValue = 360 * 4f,
        resetEffect = resetEffect
    ) { scope, animatedValue ->
        scope.rotationX = animatedValue
    }

private fun Modifier.rotateYRevealAnimation(resetEffect: Any?, animation: AnimationSpec<Float>) =
    this.genericRevealAnimation(
        animationSpec = animation,
        targetValue = 360 * 4f,
        resetEffect = resetEffect
    ) { scope, animatedValue ->
        scope.rotationY = animatedValue
    }


private fun Modifier.genericRevealAnimation(
    initialValue: Float = 0f,
    targetValue: Float = 0f,
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 1000),
    resetEffect: Any? = null,
    graphicChange: (GraphicsLayerScope, Float) -> Unit,
) = composed {
    val animatedValue = remember { Animatable(initialValue = initialValue) }
    LaunchedEffect(resetEffect) {
        animatedValue.snapTo(initialValue)
        animatedValue.animateTo(
            targetValue = targetValue,
            animationSpec = animationSpec
        )
    }
    this.graphicsLayer {
        graphicChange(this, animatedValue.value)
    }
}

@Preview(showBackground = true)
@Composable
private fun RevealAnimationScreenPreview() {
    RevealAnimationScreen()
}

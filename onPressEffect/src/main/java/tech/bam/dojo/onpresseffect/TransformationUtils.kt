package tech.bam.dojo.onpresseffect

import androidx.compose.ui.geometry.Offset


internal fun translateOffsetToCenterOrigin(
    width: Float,
    height: Float,
    offset: Offset
): Offset {
    val xOffset = width / 2
    val yOffset = height / 2
    return Offset(offset.x - xOffset, offset.y - yOffset)
}

internal fun calculateTransformationOutput(
    maxOffset: Float,
    maxTransformation: Float,
    input: Float
): Float {
    return (maxTransformation / maxOffset) * input
}

internal fun calcTransformationFromInput(centroid: Offset, width: Float, height: Float): Pair<Float, Float> {
    val coercedOffset = Offset(
        x = centroid.x.coerceIn(0F, width),
        y = centroid.y.coerceIn(0F, height)
    )
    val multiplier = 5f
    val tapOffset = translateOffsetToCenterOrigin(width, height, coercedOffset)
    val transformAngleX = calculateTransformationOutput(height, 6F * multiplier, -tapOffset.y)
    val transformAngleY = calculateTransformationOutput(width, 4F * multiplier, tapOffset.x)

    return Pair(transformAngleX, transformAngleY)
}

package tech.bam.dojo.onpresseffect

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnPressScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        FidgetCard(
            Modifier
                .fillMaxWidth(0.66f)
                .fillMaxHeight(0.2f)
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

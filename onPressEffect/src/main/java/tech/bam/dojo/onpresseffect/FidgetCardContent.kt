package tech.bam.dojo.onpresseffect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FidgetCardContent() {
    Column(
        modifier = Modifier
            // .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(color = Color.DarkGray)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.6f)
                        .height(20.dp)
                        .clip(CircleShape)
                        .background(color = Color.DarkGray)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(.4f)
                        .height(20.dp)
                        .clip(CircleShape)
                        .background(color = Color.DarkGray)
                )
            }
        }
    }
}

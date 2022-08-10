package tech.bam.dojo.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun NavButton(route: String, navController: NavHostController) {
    Button(
        onClick = {
            navController.navigate(route)
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(text = route.replace('_', ' ').lowercase(), style = MaterialTheme.typography.h6)
    }
}

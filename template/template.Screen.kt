package tech.bam.dojo.templateLowerCaseModuleName

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

class templateClassName : Screen {
    override val key = "templateModuleName"

    @Composable
    override fun Content() {
        templateModuleNameView()
    }
}

@Composable
fun templateModuleNameView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("Hello, World!")
    }
}

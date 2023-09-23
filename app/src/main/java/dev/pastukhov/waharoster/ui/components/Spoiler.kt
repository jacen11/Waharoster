package dev.pastukhov.waharoster.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter


@Composable
fun Spoiler(text: String, content: @Composable () -> Unit) {

    var visible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { visible = !visible }
        ) {
            Text(text, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.weight(1F))
            val icon = if (visible) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp
            Icon(painter = rememberVectorPainter(icon), contentDescription = "")
        }

        AnimatedVisibility(visible = visible) {
            content.invoke()
        }
    }
}
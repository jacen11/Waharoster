package dev.pastukhov.waharoster.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import dev.pastukhov.waharoster.data.WargearOption

@Composable
fun Wargear(wargears: List<WargearOption>) {
    wargears.forEach { wargear ->
        Row {
            Icon(painter = rememberVectorPainter(Icons.Filled.Clear), contentDescription = wargear.title)
            Text(text = wargear.title)
        }
        wargear.option.forEach { option ->
            Row {
                Spacer(modifier = Modifier.width(24.dp))
                Icon(painter = rememberVectorPainter(Icons.Filled.Add), contentDescription = option)
                Text(text = option)
            }
        }
    }
}
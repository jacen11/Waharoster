package dev.pastukhov.waharoster.ui.datasheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.pastukhov.waharoster.data.SampleDatasheet
import dev.pastukhov.waharoster.ui.components.Profiles
import dev.pastukhov.waharoster.ui.components.Spoiler
import dev.pastukhov.waharoster.ui.components.Wargear
import dev.pastukhov.waharoster.ui.components.WeaponInfo

@Composable
fun DatasheetScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = "Datasheet Screen" }
    ) {
        Datasheet()
    }
}

@Composable
fun Datasheet() {
    val datasheet = SampleDatasheet
    Column {
        DatasheetName(text = datasheet.name)
        ProfileTitle()
        datasheet.profiles.forEach { profile ->
            if (profile.title.isNotBlank()) {
                Text(text = profile.title)
            }
            Profiles(profile)

        }
        Spacer(modifier = Modifier.height(24.dp))
        Spoiler("Weapons") { WeaponInfo(weapons = datasheet.weapons) }
        Spacer(modifier = Modifier.height(24.dp))
        Spoiler("Wargear") { Wargear(datasheet.wargear) }
    }
}

@Composable
private fun ProfileTitle() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "M")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "T")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "Sv")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "W")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "Ld")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "OC")
    }
}

@Composable
fun DatasheetName(text: String) {
    Text(text = text, style = MaterialTheme.typography.titleLarge)
}

@Preview(showBackground = true)
@Composable
fun DatasheetPreview() {
    Datasheet()
}



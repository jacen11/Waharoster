package dev.pastukhov.waharoster.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.pastukhov.waharoster.data.Profile
import dev.pastukhov.waharoster.data.SampleDatasheet
import dev.pastukhov.waharoster.ui.theme.WaharosterTheme


@Composable
fun Profiles(profile: Profile) {
    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
        ProfilesItem(profile.move)
        Spacer(modifier = Modifier.weight(1F))
        ProfilesItem(profile.toughness)
        Spacer(modifier = Modifier.weight(1F))
        ProfilesItem(profile.save)
        Spacer(modifier = Modifier.weight(1F))
        ProfilesItem(profile.wounds)
        Spacer(modifier = Modifier.weight(1F))
        ProfilesItem(profile.leadership)
        Spacer(modifier = Modifier.weight(1F))
        ProfilesItem(profile.objectiveControl)
    }
}

@Composable
private fun ProfilesItem(text: String) {

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .border(2.dp, color = Color.Blue)
            .padding(8.dp), contentAlignment = Alignment.Center
    ) {
        Text(modifier = Modifier.padding(8.dp), text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilesPreview() {
    WaharosterTheme() {
        Column(Modifier.padding(16.dp)) {
            Profiles(SampleDatasheet.profiles.first())
        }
    }
}

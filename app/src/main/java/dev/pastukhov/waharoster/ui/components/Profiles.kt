package dev.pastukhov.waharoster.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.pastukhov.waharoster.data.Profile


@Composable
fun Profiles(profile: Profile) {
    Row {
        ProfilesItem(Modifier.weight(1F), profile.move)
        ProfilesItem(Modifier.weight(1F), profile.toughness)
        ProfilesItem(Modifier.weight(1F), profile.save)
        ProfilesItem(Modifier.weight(1F), profile.wounds)
        ProfilesItem(Modifier.weight(1F), profile.leadership)
        ProfilesItem(Modifier.weight(1F), profile.objectiveControl)
    }
}

@Composable
fun ProfilesItem(modifier: Modifier, text: String) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.border(2.dp, color = Color.Blue)
        ) {
            Text(modifier = Modifier.padding(8.dp), text = text)
        }
    }
}

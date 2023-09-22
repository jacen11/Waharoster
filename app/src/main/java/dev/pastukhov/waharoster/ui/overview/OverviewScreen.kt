package dev.pastukhov.waharoster.ui.overview

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OverviewScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = "Overview Screen" }
    ) {
        Datasheet()
    }
}

@Composable
fun Datasheet() {
    Column {
        DatasheetName(text = "Tactical Squad")
        Profiles(list = listOf("1", "2", "3", "4", "5", "6"))
        Text(text = "cgfhfvtnhs")
        Text(text = "Tactical Squad")
        Text(text = "Tactical Squad")

    }
}

@Composable
fun DatasheetName(text: String) {
    Text(text = text)
}

@Composable
fun Profiles(list: List<String>) {
    Row {
        list.forEach {
            ProfilesItem(Modifier.weight(1F), ProfilesItemData("Title", it))
        }
    }
}

data class ProfilesItemData(val title: String, val value: String)

@Composable
fun ProfilesItem(modifier: Modifier, item: ProfilesItemData) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = item.title)
        Box(
            modifier = Modifier.border(2.dp, color = Color.Blue)
        ) {
            Text(modifier = Modifier.padding(8.dp), text = item.value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DatasheetPreview() {
    Datasheet()
}



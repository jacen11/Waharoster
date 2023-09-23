package dev.pastukhov.waharoster.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.pastukhov.waharoster.data.Weapon
import dev.pastukhov.waharoster.data.weaponSample1
import dev.pastukhov.waharoster.data.weaponSample2

@Composable
fun WeaponInfo(weapons: List<Weapon>) {
    Column {
        WeaponTitle()
        weapons.forEach { weapon ->
            Spacer(modifier = Modifier.height(8.dp))
            WeaponDetailInfo(weapon)
        }
    }
}

@Composable
fun WeaponDetailInfo(weapon: Weapon) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall,
            text = weapon.name
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(modifier = Modifier.weight(2F), textAlign = TextAlign.Center, text = weapon.range)
            Text(
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Center,
                text = weapon.attacks
            )
            Text(
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Center,
                text = weapon.ballisticSkill
            )
            Text(
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Center,
                text = weapon.strength
            )
            Text(
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Center,
                text = weapon.armourPenetration
            )
            Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = weapon.damage)
        }
    }
}

@Composable
private fun WeaponTitle() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(modifier = Modifier.weight(2F), textAlign = TextAlign.Center, text = "Range")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "A")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "BS")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "S")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "AP")
        Text(modifier = Modifier.weight(1F), textAlign = TextAlign.Center, text = "D")
    }
}

@Preview(showBackground = true)
@Composable
fun WeaponTitlePreview() {
    WeaponTitle()
}

@Preview(showBackground = true)
@Composable
fun WeaponInfoPreview() {
    WeaponInfo(listOf(weaponSample1, weaponSample2))
}
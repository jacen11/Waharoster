package dev.pastukhov.waharoster.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.ui.graphics.vector.ImageVector

enum class WeaponType(val title: String, val icon: ImageVector) {
    Ranged("RANGED WEAPONS", Icons.Filled.Clear), Melee("MELEE WEAPONS", Icons.Filled.ArrowForward)
}

data class Weapon(
    val type: WeaponType,
    val name: String,
    val range: String,
    val attacks: String,
    val ballisticSkill: String,
    val strength: String,
    val armourPenetration: String,
    val damage: String,
    val keywords: List<KeywordWeapon> = emptyList(),
)

val weaponSample1 = Weapon(
    type = WeaponType.Ranged,
    name = "Rifle",
    range = "24\"",
    attacks = "2",
    ballisticSkill = "3",
    strength = "4",
    armourPenetration = "5",
    damage = "6"
)

val weaponSample2 = Weapon(
    type = WeaponType.Ranged,
    name = "Flamer",
    range = "24\"",
    attacks = "2",
    ballisticSkill = "3",
    strength = "4",
    armourPenetration = "5",
    damage = "6",
    keywords = listOf(
        KeywordWeapon(
            " torrent",
            "Torrent weapons shoot clouds of fire, gas or other lethal substances that few foes can hope to evade."
        )
    )
)

val weaponSample3 = Weapon(
    type = WeaponType.Melee,
    name = "Sword",
    range = "Melee",
    attacks = "2",
    ballisticSkill = "3",
    strength = "4",
    armourPenetration = "5",
    damage = "6",
    keywords = listOf(
        KeywordWeapon(
            " torrent",
            "Torrent weapons shoot clouds of fire, gas or other lethal substances that few foes can hope to evade."
        ),
        KeywordWeapon(
            " Blast",
            "High-explosives can fell several warriors in a single blast, but firing them where your comrades will get caught in the ensuing detonation is simply unwise."
        ),
    )
)

val sampleWeaponList: List<Weapon> = listOf(weaponSample1, weaponSample2, weaponSample3)

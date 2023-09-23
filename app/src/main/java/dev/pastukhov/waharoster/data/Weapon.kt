package dev.pastukhov.waharoster.data

enum class WeaponType {
    Ranged, Melee
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

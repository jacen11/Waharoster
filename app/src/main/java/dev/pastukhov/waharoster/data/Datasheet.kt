package dev.pastukhov.waharoster.data

class Datasheet(
    val name: String,
    val profiles: List<Profile>,
    val weapons: List<Weapon>,
    val wargear: List<WargearOption>,
    val abilities: String,
    val factionKeywords: String,
    val keywords: String,
)

data class Profile(
    val move: String,
    val toughness: String,
    val save: String,
    val wounds: String,
    val leadership: String,
    val objectiveControl: String,
    val title: String,
)

data class WargearOption(val title: String, val option: List<String>)

data class FactionKeywords(val name: String)

val SampleWargearOption1 = WargearOption(
    "The Biker Sergeant’s bolt pistol can be replaced with one of the following:",
    option = listOf("1 Astartes chainsword", "1 boltgun", "1 combi-weapon")
)
val SampleWargearOption2 = WargearOption(
    "Any number of Space Marine Bikers can each have their bolt pistol replaced with 1 Astartes chainsword",
    option = emptyList()
)

val SampleDatasheet = Datasheet(
    name = "Bike Squad",
    profiles = listOf(
        Profile(move = "12\"", toughness = "5", save = "3+", wounds = "3", leadership = "6+", objectiveControl = "2", title = "SPACE MARINE BIKE"),
        Profile(move = "12\"", toughness = "5", save = "3+", wounds = "5", leadership = "6+", objectiveControl = "2", title = "ATTACK BIKE")
    ),
    weapons = sampleWeaponList,
    wargear = listOf(SampleWargearOption1, SampleWargearOption2),
    abilities = "",
    factionKeywords = "",
    keywords = "",
)
fun main(args: Array<String>) {
    val name = "Matt"
    var hp = 70
    val isBlessed = true
    val isImmortal = false

    // Aura code
    val auraColor = auraColor(isBlessed, hp, isImmortal)

    //Status
    val healthStatus = formatHealthStatus(hp, isBlessed)

    //Output
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball(5)
}

// I can omit the braces, return type and return statement on functions that only evaluate a single expression.
private fun formatHealthStatus(hp: Int, isBlessed: Boolean) =
    when (hp) {
        100 -> "is in excellent condition!"
        in 75..99 -> "has a few minor cuts and bruises here and there."
        in 50..74 -> if (isBlessed) {
            "has some lacerations, but is rapidly recovering"
        } else {
            "has some lacerations and potentially internal bleeding."
        }
        in 25..49 -> "is hemorrhaging blood and has multiple fractures. Seek medical attention immediately!"
        else -> "has ruptured organs and is bordering on shock. I hope you wrote your will..."
}

private fun auraColor(isBlessed: Boolean, hp: Int, isImmortal: Boolean) =
    if (isBlessed && hp > 50 || isImmortal) "GREEN"
    else "NONE"

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                " (Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun castFireball(numFireballs: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
}

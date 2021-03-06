package chapter13

fun main() {
    val player2 = Player3("Madrigal", healthPoints =100, isBlessed = true, isImmotal = false)
    player2.castFireball()
    printPlayerStatus2(player2)
}

private fun printPlayerStatus2(player: Player3) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
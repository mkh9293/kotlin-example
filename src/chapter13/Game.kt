package chapter12

fun main() {
    val player = Player3("Madrigal", 89, true, false)
    player.castFireball()

    printPlayerStatus2(player)
}

private fun printPlayerStatus2(player: Player3) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
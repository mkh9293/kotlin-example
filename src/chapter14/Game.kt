package chapter14

fun main() {
    val player = Player3("Madrigal")
    player.castFireball()

    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    printIsSourceOfBlessings(player)
}

fun printIsSourceOfBlessings(any : Any) {
    val isSourceOfBlessings = if (any is Player3) {
        any.isBlessed
    } else {
        (any as Room).name = "Fount of Blessings"
    }

    println("$any is a source of blessings: $isSourceOfBlessings")
}

private fun printPlayerStatus2(player: Player3) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
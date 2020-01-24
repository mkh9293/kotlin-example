package chapter15

object Game {
    private val player = Player3("Madrigal")
    private var currentRoom: Room = TownSquare()

    init {
        println("방문을 환영합니다.")
        player.castFireball()
    }

    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus2(player)

            print("> 명령을 입력하세요: ")
            println("최근 명령: ${readLine()}")
        }
    }

    private fun printPlayerStatus2(player: Player3) {
        println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}

fun main() {
    Game.play()

    val abandonedTownSqure = object : TownSquare() {
        override fun load2() = "test"
    }
}
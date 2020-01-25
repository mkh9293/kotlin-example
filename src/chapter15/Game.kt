package chapter15

import java.lang.IllegalStateException

object Game {
    private val player = Player3("Madrigal")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    private fun move(directionInput : String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if(!newPosition.isInBounds) {
                throw IllegalStateException("$direction 쪽 방향이 범위를 벗어남.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, $direction 방향의 ${newRoom.name}로 이동했습니다."
        } catch(e : Exception) {
            "잘못된 방향임: $directionInput."
        }

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
            val result = GameInput(readLine()).processCommand()
            if(result == "quit" || result == "exit")
                break
            println(result)
        }
    }

    private fun printPlayerStatus2(player: Player3) {
        println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        fun processCommand() = when(command.toLowerCase()) {
            "move" -> move(argument)
            "quit" -> "quit"
            "exit" -> "exit"
            "map" -> player.currentPosition
            "ring" -> TownSquare().ringbell()
            else -> commandNotFound()
        }

        private fun commandNotFound() = "적합하지 않은 명령입니다!"

    }
}

fun main() {
    Game.play()

    val abandonedTownSqure = object : TownSquare() {
        override fun load2() = "test"
    }
}
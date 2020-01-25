package chapter16

import java.lang.IllegalStateException
import kotlin.system.exitProcess

object Game {
    private val player = Player("Madrigal")
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

    private fun fight() = currentRoom.monster?.let {
        while(player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }

        "전투가 끝났음."
    } ?: "여기에는 싸울 괴물이 없습니다..."

    private fun slay(monster: Monster) {
        println("${monster.name} -- ${monster.attack(player)} 손상을 입힘!")
        println("${player.name} -- ${player.attack(monster)} 손상을 입힘!")

        if(player.healthPoints <= 0) {
            println(">>>> 당신은 졌습니다! 게임을 종료합니다.. <<<<")
            exitProcess(0)
        }

        if(monster.healthPoints <= 0) {
            println(">>>> ${monster.name} -- 격퇴됨! <<<<")
            currentRoom.monster = null
        }
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

    private fun printPlayerStatus2(player: Player) {
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
            "fight" -> fight()
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
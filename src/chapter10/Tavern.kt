package chapter10

import chapter8.placeOrder

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList: List<String> = listOf("Eli", "Mordoc", "Sopie")
fun main() {
    placeOrder("shanday,Dragon's Breath,5.91")

    println(patronList[2])
}
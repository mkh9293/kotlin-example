package chapter18

import java.io.File
import extensions.random

const val TAVERN_NAME = "Taernyl's Folly"

val patronList: List<String> = listOf("Eli", "Mordoc", "Sopie")
val lastName = listOf("Ironfoot", "Fernsworh", "Baggins")
var menuList = File("data/tavern-menu-items.txt").readText().split("\r\n")

val uniquePatrons = mutableSetOf<String>()

fun main() {
    (0..9).forEach {index ->
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    var orderCount = 0
    while(orderCount <= 9) {
        placeOrder(uniquePatrons.random(), menuList.random())
        orderCount++
    }

}

fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName 은 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName 은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName 이 감탄한다: 와, $name 진짜 좋구나!"
    } else {
        "$patronName 이 말한다: 감사합니다 $name."
    }
    println(phrase)
}
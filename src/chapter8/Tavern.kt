package chapter8

import java.math.BigDecimal
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernly's Folly"

var playerGold = 10
var playerSilver = 10

fun main() {
    println(100.12.roundToInt())
//    val a : Float = 10.1f
//    val b : Float = 5.91f
////    println(a.toBigDecimal()-b.toBigDecimal())
//    println(a-b)
    placeOrder("shandy,Dragon's Breath,5.91")
}

fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리갈은 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(',')
    val message = "마드리갈은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

    performPurchase(price.toDouble())
    performPurchase(price.toDouble())
    performPurchase(price.toDouble())
    performPurchase(price.toDouble())
    performPurchase(price.toDouble())
    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "마드리갈이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "마드리갈이 말한다: 감사합니다 $name."
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiou]")) {
    when(it.value) {
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        else -> it.value
    }
}

fun performPurchase(price: Double) {
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("지갑 전체 금액: 금화 $totalPurse")
//    displayBalance()
    println("금화 $price 로 술을 구입함")

    val remaininBalance = totalPurse - price
    println("남은 잔액: ${"%.2f".format(remaininBalance)}")
    if(remaininBalance <= 0) {
        println("금화 부족")
        return
    }

    val remainingGold = remaininBalance.toInt()
    val remainingSilver = (remaininBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: $playerGold 개, 은화: $playerSilver 개")
}
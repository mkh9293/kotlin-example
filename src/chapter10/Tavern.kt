package chapter10

import chapter8.placeOrder

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList: List<String> = listOf("Eli", "Mordoc", "Sopie")

val patronList2: MutableList<String> = mutableListOf("Eli", "Mordoc", "Sopie")
fun main() {
    placeOrder("shanday,Dragon's Breath,5.91")

    println(patronList[2])
    println(patronList.first())
    println(patronList.last())
    println(patronList.getOrElse(4) {"Unknown Patrom"})
    println(patronList.getOrNull(4) ?: "Unknown Patrom")

    var result = if(patronList.contains("Eli")) {
        "술집 주인이 말한다: Eli는 안쪽 방에서 카드하고 있어요."
    } else {
        "술집 주인이 말한다: Eli는 여기 없어요."
    }
    println(result)

    result = if(patronList.containsAll(listOf("Sopie","Mordoc"))) {
        "술집 주인이 말한다: 네, 모두 있어요."
    } else {
        "술집 주인이 말한다: 아니오, 나간 사람도 있습니다."
    }
    println(result)

    patronList2.remove("Eli")
    patronList2.add("Alex")
    patronList2.add(0, "Alex")
    println(patronList2)
}
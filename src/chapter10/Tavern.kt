package chapter10

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList: List<String> = listOf("Eli", "Mordoc", "Sopie")

val patronList2: MutableList<String> = mutableListOf("Eli", "Mordoc", "Sopie")
val lastName = listOf("Ironfoot", "Fernsworh", "Baggins")
var menuList = File("data/tavern-menu-items.txt").readText().split("\r\n")

val uniquePatrons = mutableSetOf<String>()
fun main() {
    patronList.forEachIndexed { index, patron ->
        println("좋은 밤입니다, $patron 님 - 당신은 #${index+1} 번째입니다.")
        placeOrder(patron, menuList.shuffled().first())
    }

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

    menuList.forEachIndexed { index, data ->
        println("$index : $data")
    }

    (0..9).forEach {index ->
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    var orderCount = 0
    while(orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    // list -> set -> list (list에서 set으로 변환하는 과정에서 중복 요소제거)
    var listToSetAndToList = menuList.toSet().toList()
    println(listToSetAndToList)

    // list의 중복요소를 제거하는 함수.
    // 내부적으로 toSet, toList를 호출한다고 함
    var patrons = menuList.distinct()
    println(patrons)
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
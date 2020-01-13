package chapter18

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint() : T {
    println(this)
    return this
}

fun main() {
//    println("마드리갈이 그 건물에서 나왔습니다".addEnthusiasm())
    "마드리갈이 그 건물에서 나왔습니다".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()
}
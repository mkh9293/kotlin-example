package chapter6

fun main(args: Array<String>) {
    var beverage = readLine()!!.capitalize()

//    var beverage = readLine()?.let {
//        if(it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "맥주"
//        }
//    }

//    var beverage = readLine()?.capitalize()
//    beverage = null
    println(beverage)
}
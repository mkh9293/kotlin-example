package chapter3

fun main(args: Array<String>) {
    val name = "name"
    val status = "status"
    val check = true
    println("name $name , status : ${if (check) status else ""}")

    println((1..3).toList())
    println(3 in 1 until 3)   // true
    println(3 in 3 downTo 1)  // true
}
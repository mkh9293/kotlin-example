package chapter5

fun main() {
    val numLetters = "Mississippi".count()
    println(numLetters)

    val numLetters2 = "Mississippi".count({letter -> letter == 's'})
    println(numLetters2)

    val numLetters3 = "Mississippi".count({it == 's'})
    print(numLetters3)

    val numLetters4 = "Mississippi".count{it == 's'}
    print(numLetters4)
}
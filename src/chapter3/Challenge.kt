package chapter3

fun main(args: Array<String>) {
    val healthPoints = 80
    val auraVisible = true
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    val auraColor = when (karma) {
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purple"
        in 16..20 -> "green"
        else -> "none"
    }
    println("${if(auraVisible) auraColor else ""}")


    /* 형식 문자열 */
    val isBlessed = true
    val healthStatus4 = "경미한 상처가 있지만 빨리 치유되고 있음!"

    val HP = "HP: $healthPoints"
    val A = "Aura: ${if(isBlessed) auraColor else ""}"
    val H = healthStatus4
    val statusFormatString = "(HP)(A) -> H"
    println(statusFormatString.replace("HP", "#P").replace("A", A).replace("H", H).replace("#P", HP))
}
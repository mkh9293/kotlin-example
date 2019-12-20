package chapter8

fun main() {
    // 정숫값을 이진 형태의 문자열로 반환
    val a = Integer.toBinaryString(42)
    println(a) // 101010

    // 파라미터로 지정된 비트 수만큼 모든 비트를 왼쪽으로 이동 (부호비트는 그대로)
    val b = 42.shl(2)
    println(b) // 10101000

    // 파라미터로 지정된 비트 수만큼 모든 비트를 오른쪽으로 이동 (부호비트는 그대로)
    val c = 42.shr(2)
    println(c) // 1010

    // 파라미터로 지정된 비트 수만큼 모든 비트를 오른쪽으로 이동 (부호비트도 이동)
    val d = 42.ushr(2)
    println(d)

    // 모든 비트의 값을 반대로 변경
    val e = 42.inv()
    println(e)

    // xor, or, and 연산 수행
    val f = 42.xor(33)
    val g = 42.or(33)
    val h = 42.and(33)
    println("$f, $g, $h")
}
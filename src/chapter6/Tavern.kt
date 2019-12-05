package chapter6

fun main(args: Array<String>) {
    // ?: null 복합 연산자
    // 왼쪽 피연산자의 결과가 null 이면 오른쪽 피연산자를 실행
    // 아니면 왼쪽 결과를 반환.

    var beverage6 = readLine()
    if(beverage6 != null) {
        beverage6 = beverage6.capitalize()
    } else {
        println("beverage가 null입니다!")
    }

    val beverageServed = beverage6 ?: "맥주"
    println(beverageServed)

    // 안전 호출 연산자가 코드가 간결하고 유연하다.
    var beverage5 = readLine()?.capitalize()?.plus(", large")

    // if 문과 != 연산자 사용
    var beverage4 = readLine()
    if(beverage4 != null) {
        beverage4 = beverage4.capitalize()
    } else {
        println("beverage가 null입니다!")
    }

    // !! 더블뱅 연산자 사용
    // 해당 함수나 변수가 어떤 값이든 상관하지 않고 뒤에 함수를 호출 할 수 있도록 함.
    var beverage3 = readLine()!!.capitalize()

    // let 함수 사용 (with. 안전 호출 연산자)
    // null 이 아닌 경우 값 초기화할 수 있도록 함.
    var beverage2 = readLine()?.let {
        if(it.isNotBlank()) {
            it.capitalize()
        } else {
            "맥주"
        }
    }

    // 안전 호출 연산자 사용
    // ?. 는 값이 null이 아닌 경우에만 뒤에 있는 함수를 호출한다.
    // 만약, null 이면 뒤에 있는 연산자를 무시하고 다음 연산을 수행한다.
    var beverage1 = readLine()?.capitalize()
//    beverage = null
    println(beverage6)
}
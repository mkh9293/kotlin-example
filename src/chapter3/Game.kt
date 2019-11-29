package chapter3

fun main(args: Array<String>) {
    val name = "마드리길"
    var healthPoints = 75
    val isBlessed = true
    val isImmotal = false

    /* 논리연산자 이용 */
    val auraVisible = isBlessed && healthPoints > 50 || isImmotal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

    /* 범위 */
    val heathStatus2 = if(healthPoints == 100) {
        "최상의 상태임!"
    } else if (healthPoints in 90..99) {
        "약간의 찰과상만 있음."
    } else if (healthPoints in 75..89) {
        if(isBlessed) {
            "경미한 상처가 있지만 빨리 치유됨!"
        } else {
            "경미한 상처만 있음."
        }
    } else if (healthPoints in 15..74) {
        "많이 다친 것 같음."
    } else {
        "최악의 상태임!"
    }

    println(name + " " + heathStatus2)


    /* 조건 표현식 */
    val healthStatus = if(healthPoints == 100) {
        "최상의 상태임!"
    } else if (healthPoints >= 90) {
        "약간의 찰과상만 있음."
    } else if (healthPoints >= 75) {
        if(isBlessed) {
            "경미한 상처가 있지만 빨리 치유됨!"
        } else {
            "경미한 상처만 있음."
        }
    } else if (healthPoints >= 15) {
        "많이 다친 것 같음."
    } else {
        "최악의 상태임!"
    }

    println(name + " " + healthStatus)

    /* 기본 조건문 */
    if(healthPoints == 100) {
        println(name + " 최상의 상태임!")
    } else if (healthPoints >= 90) {
        println(name + " 약간의 찰과상만 있음.")
    } else if (healthPoints >= 75) {
        if(isBlessed) {
            println(name + " 경미한 상처가 있지만 빨리 치유됨!")
        } else {
            println(name + " 경미한 상처만 있음.")
        }
    } else if (healthPoints >= 15) {
        println(name + " 많이 다친 것 같음.")
    } else {
        println(name + " 최악의 상태임!")
    }

    /* when 표현식 */
    val healthStatus3 = when (healthPoints) {
        100 -> " 최상의 상태임!"
        in 90..99 -> "약간의 찰과상만 있음."
        in 75..89 -> if (isBlessed) {
                        "경미한 상처가 있지만 빨리 치유되고 있음!"
                    } else {
                        "경미한 상처만 있음."
                    }
        in 15..74 -> "많이 다친 것 같음."
        else -> "최악의 상태임!"
    }
    println(name + " " + healthStatus3)

    val healthStatus4 = when (healthPoints) {
        100 -> " 최상의 상태임!"
        in 90..99 -> "약간의 찰과상만 있음."
        in 75..89 -> when (isBlessed) {
                        true -> "경미한 상처가 있지만 빨리 치유되고 있음!"
                        false -> "경미한 상처만 있음."
                    }
        in 15..74 -> "많이 다친 것 같음."
        else -> "최악의 상태임!"
    }
    println(name + " " + healthStatus4)


    /* 문자열 템플릿 */
    println("(Aura: $auraColor) (Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")

}
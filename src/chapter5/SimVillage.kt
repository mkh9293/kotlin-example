package chapter5

fun main() {
    println({
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }())

    val greetingFunction: () -> String = {
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }
    println(greetingFunction())

    val greetingFunction2: (String) -> String = { playerName ->
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
    println(greetingFunction2("김선달"))

    val greetingFunction3: (String) -> String = {
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, $it 님! (copyright $currentYear)"
    }
    println(greetingFunction3("김선달"))

    val greetingFunction4: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
    println(greetingFunction4("김선달", 2))

    val greetingFunction5 = {
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }
    println(greetingFunction5())

    val greetingFunction6 = { playerName: String, numBuildings: Int ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName! (copyright $currentYear)"
    }
    runSimulation("김선달", greetingFunction6)

    runSimulation("김선달") { playerName, numBuildings ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName! (copyright $currentYear)"
    }
}

inline fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}
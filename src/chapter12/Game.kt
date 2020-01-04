package chapter12

fun main() {
    val name = "마드리길"
    val healthPoints = 75
    val isBlessed = true
    val isImmotal = false

    val player = Player()
    player.castFireball()
    
    val auraColor = auraColor(isBlessed, healthPoints, isImmotal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor = auraColor, isBlessed = isBlessed, healthStatus=healthStatus, name = name)
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmotal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmotal) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
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

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) (Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}
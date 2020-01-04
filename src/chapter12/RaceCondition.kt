package chapter12

class Weapon(val name: String)

class Player2 {
    var weapon: Weapon? = Weapon("Ebony Kris")

    // println 시, weapon이 null 값을 가질 수 없는 Weapon 타입으로 일시 변환해주는데, (스마트 캐스팅)
    // 여러 스레드에서 weapon 값을 동시에 바꿔질 수 있기 때문에 (race condition)
    // 스마트 캐스팅을 할 수 없어서 error
    fun printWeaponName2() {
        if( weapon != null ) {
            println(weapon.name)
        }
    }

    // also를 사용하는 순간부터 it 는 지역변수가 됨. ( "?." 안전호출연산자로 null 이 아닌 값으로 확인)
    // also의 익명함수 내에서만 존재하는 it 변수이기 때문에 race condition에 의해 값이 변경될 수 없음.
    fun printWeaponName() {
        weapon?.also{
            println(it.name)
        }
    }
}

fun main() {
    Player2().printWeaponName()
}
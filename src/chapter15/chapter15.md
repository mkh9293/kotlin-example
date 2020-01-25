### chapter15 : 객체

---

#### object 키워드  

object 키워드는 선언하는 위치에 따라 다양하게 활용할 수 있다.  
java에 있는 static 키워드가 코틀린에는 없기 때문에 비슷하게 사용할 수 있다.    
  
- 객체 선언  
- 객체 표현식  
- 동반 객체

<br>


- 객체 선언  
클래스 선언처럼 똑같이 생성하지만, class 대신 object 키워드를 사용한다.  
싱글톤으로 생성되어 하나의 인스턴스만 필요하다면 object 키워드로 생성하여 사용한다.  
  
- 객체 표현식  
익명 클래스를 사용할 필요가 있을 경우 object 키워드를 붙인다.  

```kotlin
val abandonedTownSqure = object : TownSquare() {
        override fun load2() = "test"
    }
```

위 코드처럼 익명 클래스를 만들게 되면 TownSquare 클래스의 서브 클래스의 인스턴스가 생성되어   
사용한 것과 같다. (중괄호 내부는 클래스 몸체가 된다.)

주의할 점은 클래스를 생성하고 인스턴스가 생성되기 때문에 매 호출 시마다 인스턴스가 생성되므로  
시스템에 부하가 올 수도 있다. (싱글톤이 안됨)

- 동반 객체

객체 선언과 똑같지만, 최상위 수준에서는 사용할 수 없고 클래스 내부에서만 사용가능하다.  
객체 선언과 또 다른 점은 클래스 내부에 선언된 객체 선언에 있는 함수, 속성을 외부에서 사용하려면  
    
해당 클래스 이름.객체 선언 이름으로 호출해야 하지만  
동반 객체는 해당 클래스의 이름만으로도 동반객체에 있는 함수, 속성을 사용할 수 있다.  

```kotlin
class PremadeWorldMap {
    companion object {
        private const val MAPS_FILEPAHT = "~.map"
        fun load() = File(MAPS_FILEPAHT).readBytes()
    }
}
```

<br>
---

#### 중첩 클래스

코틀린의 중첩 클래스는 외곽 클래스가 생성되어야 하며, 외곽 클래스에서는 중첩 클래스의 속성과 함수를 사용할 수 있다.  


<br>
---

#### 데이터 클래스

데이터 클래스는 데이터를 저장하기 위해 특별히 설계된 클래스.  
(강력한 데이터 처리기능을 가지고 있음.)  

데이터 클래스는 toString() 함수를 따로 재정의하지 않아도 자동으로 만들어준다.  
  
또한 equals() 메소드도 재정의해주기 때문에 Coordinate(1, 2) == Coordinate(1, 2) 가 false가 아닌  
true 가 된다. (참고로 기본 생성자에 정의된 속성만으로 비교됨.)  

copy() 메소드도 자동 생성해줌.  
(새로운 인스턴스 복제가 간단해짐.)
```kotlin
val mortalPlayer = player.copy(isimmotal = false)
```


데이터 클래스는 toString, equals, hashCode, copy 함수가 필요없을 때에는 사용할 필요가 없다.  
(다시 말해서 위 함수들을 쉽게 사용할 용도일 경우만 데이터 클래스로 정의하면 된다.)  
  
<br>
---

#### enum 클래스

일련의 상숫값을 정의하는 열거형 타입을 정의할 때 사용.  
java 와 비슷한듯.?  


<br>
---

#### 질문.

291p 에 아래 함수를 호출하는 Game.kt 에서 리턴타입이 없는데도 newPosition 변수에서 받고 있다.  
역컴파일 해보면 java로 리턴되도록 되어 있는건 확인함.  
리턴 타입이 없는데도 어떻게 리턴되도록 되어있는가..  
 
```kotlin
fun updateCoordinate(playerCoordinate: Coordinate) = coordinate + playerCoordinate
```

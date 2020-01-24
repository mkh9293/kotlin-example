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

---

#### 중첩 클래스


  
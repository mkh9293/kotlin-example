### chapter14 : 상속

---

- 접근제한자   
open, final, override, abstract  


코틀린은 접근제한자를 명시적으로 주지 않으면 기본적으로 final 이다.  
서브클래스를 생성하기 위해서 open 키워드를 추가해야 한다.  
  
open 키워드를 통해 생성된 클래스에서 서브클래스를 만들면  
해당 서브클래스에 정의된 속성이나 함수는 자동으로 open 으로 만들어지기 때문에  
해당 서브클래스의 서브클래스에서 override 를 못하게 하려면 명시적으로 final을 붙여주어야 한다.  

<br>

- 가시성제한자  
public, private, package, internal
  
코틀린은 가시성제한자를 명시적으로 주지 않으면 기본적으로 public이다.  
package는 해당 클래스의 내부와 서브 클래스까지 이며,  
internal은 모듈 내부에서 모두 호출하여 사용할 수 있다.

  
<br>

- is, as 키워드

```kotlin
fun printIsSourceOfBlessings(any : Any) {
    val isSourceOfBlessings = if (any is Player3) {
        any.isBlessed
    } else {
        (any as Room).name = "Fount of Blessings"
    }

    println("$any is a source of blessings: $isSourceOfBlessings")
}
```
코틀린에서 모든 클래스는 Any 클래스의 서브 클래스이므로 함수 인자로 Any를 줄 경우,  
모든 서브 클래스를 받을 수 있다.  

is 키워드는 타입 검사를 하는 키워드이다.  
위 코드에서 if문으로 타입 검사를 진행하고 해당 블록에서 Player3 클래스에만 있는 isBlessed  
속성을 호출했다.  
코틀린의 스마트 캐스팅 덕분에 타입변환을 하지 않아도 위 코드가 동작한다.  

as 키워드는 타입 변환을 나타낸다.  
Room 클래스도 마찬가지로 Any 클래스의 서브클래스이므로 타입변환이 가능하므로 Room 클래스에 있는  
name 속성을 변경할 수 있다.  
  
> 참고
as 키워드로 타입변환이 가능한 조건은 서브 클래스일 경우만 성립된다.  
즉, Int -> String 은 타입 변환 불가.    











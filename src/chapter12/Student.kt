package chapter12

/**
 * 산출 속성은 내부적으로 getter만 생성됨.
 *
 */
class Student1 {
    val name: String
        get() = "Madrigal"
}

/**
 * val 키워드 속성은 내부적으로 setter를 제외한 나머지 요소만 생성됨.
 * 필드, getter, 기본 생성자
 */
class Student2(val name: String)

/**
 * var 키워드 속성은 내부적으로 모든 요소들이 생성됨.
 * 필드, getter, setter, 기본 생성자
 */
class Student3(var name: String)
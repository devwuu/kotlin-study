package javaToKotlin

import javaToKotlin.javas.Person


// 코틀린 class 에서는 프로퍼티를 만들면 필드, getter, setter를 자동으로 만들어준다
// 그래서 java 코드처럼 getter와 setter를 명시적으로 만들어주지 않아도 된다

// 코틀린의 기본 접근 제어자는 public이다 => 생략 가능
public class Human0(name: String, age: Int){
     val name: String = name; // 프로퍼티 = 필드 + getter + setter
     var age: Int = age;
}

class Human1 constructor(name: String, age: Int){
     val name: String = name; // 프로퍼티 = 필드 + getter + setter
     var age: Int = age;
}

// constructor 생략 가능
// 생성자를 만들어 주면서 프로퍼티를 동시에 선언 가능
class Human2 (
     private val name: String,
     private var age: Int){

}

// class body에 아무것도 없으면 {} 중괄호 생략 가능
class Human3 (val name: String, var age: Int)

// 코틀린에서는 .필드 를 이용해 바로 getter와 setter를 호출할 수 있다.
// 이게 필드를 가져다가 쓰는 게 아니라 getter랑 setter를 가져다가 쓰는 것임


// 주생성자는 반드시 존재해야 한다
// 개발자가 생성자를 선언하지 않으면 코틀린이 자동으로 주생성자를 만들어 준다 ==> constructor()
// 부 생성자는 optional 하다
// 부 생성자는 최종적으론 꼭 주 생성자를 호출해야 한다
class Human4 (val name: String, var age: Int){ // 주생성자
    // 인스턴스 생성 시점에 한 번 실행되는 init 블럭
    init {
        println("init called")
        if (age <=0 )
            throw IllegalArgumentException("나이는 0이하가 될 수 없습니다")
    }

    // 부생성자1
    constructor(name: String): this(name, 1){
                                // 주 생성자를 호출한다
                                // 이때 보조 생성자를 이용해 받을 파라미터는 보조 생성자에 넣고
                                // 바로 셋팅해줄 파라미터는 this에 넣어준다

        println("constructor(name: String)")
        // init block 실행 후 실행된다
    }

    // 부 생성자 2
    constructor(): this("empty") {
        // 부 생성자1을 호출하는 부 생성자 2
        println("constructor()")

    }

}

class Human5(
    name: String="james", // custom getter를 사용하기 위해 키워드(val, var) 제거
    var age: Int=1){

    fun isAdult1(): Boolean{
        return this.age >= 20
    }

    // custom getter
    // 마치 isAdult라는 프로퍼티가 있는 것처럼
    // 평범한 프로퍼티처럼 .isAdult를 호출해 사용할 수 있다
    val isAdult : Boolean
        get() = this.age >= 20

    // 다른 함수처럼 중괄호를 넣어서 써줄 수도 있다
    val isAdult2 : Boolean
        get() {
            return this.age >= 20
        }

    // name의 getter를 호출할 때 이 custom getter를 가져다가 사용하게 한다
    // getter를 재정의하는 것처럼 느껴짐
    var name = name // 생성자에서 받은 파라미터를 name을 할당
     get() = field.uppercase() // field ? name을 사용할 수 없는 이유
                                // name을 사용(호출)하면 name의 getter를 호출
                                // 근데 getter에서는 또 name의 getter를 호출(name을 가져다 써서)
                                // 따라서 계속 자기 자신을 반복해서 부르는 현상이 생긴다
                                // 무한 루프를 막기 위해 자기 자신(field)를 가리키는 예약어를 사용한다
                                // backing field
    set(value) {
        field = value.uppercase()
    }
}

    // name의 setter를 호출할 때 이 custom setter를 가져다가 사용하게 한다
    // 하지만 setter 자체를 지양하다보니 많이 사용하진 않는다
    // custom getter와 이름이 겹치면 안되는 거 같다....
    // ==> get() set() 을 상위처럼 나란히 정의해야 함
//    var name = name // 생성자에서 파라미터로 받은 name을 할당
//        set(value) {
//            field = value.uppercase() // 필드에 전달받은 value를 할당
//        }
//}

// backing field 를 대체하는 방법...
class Human6(
    val name: String="james", // custom getter를 사용하기 위해 키워드(val, var) 제거
    var age: Int=1){

    fun getUpperCaseName1(): String{
        return this.name.uppercase()
    }

    val upperCaseName2: String
        get() = this.name.uppercase()

}


fun main() {
    val human2 = Human2("james", 20)
    val human3 = Human3("james", 20)
//    println(human2.age)
    // Cannot access 'age': it is private in 'Human2'
    // 프로퍼티를 private으로 선언하면 getter, setter도 private이 된다
    println(human3.age) // getter 호출
    human3.age = 30 // setter 호출
    println(human3.age)

    // 코틀린에서 자바 클래스를 가져다 쓸 때도 코틀린 클래스와 동일하게 사용한다
    val person = Person("java", "1")
    println(person.name)
    // name필드는 private
    // name필드를 가져다가 사용하는 것이 아니라 getName을 호출한 것

//    val human4 = Human4("james", 0)
    // Exception in thread "main" java.lang.IllegalArgumentException: 나이는 0이하가 될 수 없습니다
    //	at javaToKotlin.Human4.<init>(Classes.kt:38)
    //	at javaToKotlin.ClassesKt.main(Classes.kt:59)
    //	at javaToKotlin.ClassesKt.main(Classes.kt)

    val human6 = Human4("jenny", 10)
    // init called
    println("--------")

    val human5 = Human4("jenny")
    // init called
    //constructor(name: String)
    println(human5.age)

    println("--------")
    val human4 = Human4()
    // init called
    //constructor(name: String)
    //constructor()
    println(human4.name)

    // 출력 순서는 호출 순서의 반대
    // 부셍성자 2를 호출하기 위해선 부생성자1을 먼저 호출해야 하고
    // 부생성자 1을 호출하기 위해선 주생성자를 먼저 호출해야 하기 때문에
    // init -> 부생성자1 -> 부생성자2 순으로 호출

    // 하지만 코틀린에서는 기본적으로 부 생성자보다 default value를 추천합니다
    // default 값을 이용하면 생성자를 여러개 오버로딩한 것과 동일한 효과가 일어납니다
    val human51 = Human5("kate", 20)
    val human52 = Human5("kate")
    val human53 = Human5()
    println(human51.age)
    println(human52.age)
    println(human53.name)
    // 아니면 정적 팩토리 메서드를 사용합니다 ==> companion object

    println(human51.isAdult)
    println(human51.isAdult2)
    println(human51.isAdult1())
    println(human51.name)

    // 그럼 둘은 어떤 기준을 가지고 사용해줄 수 있을까?
    // 객체의 속성 ==> custom getter
    // 객체의 함수 ==> method

    val human61 = Human6()
    println(human61.upperCaseName2)
    println(human61.getUpperCaseName1())

}
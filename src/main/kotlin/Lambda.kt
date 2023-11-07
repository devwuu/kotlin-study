
// lambda 의 기본 정의
// 마치 value처럼 다룰 수 있는 익명함수
// val lambdaName : Type = { args -> codeBody }

val square : (Int) -> Int = {num -> num*num};
// name : (인자타입) -> return타입 = { 파라미터 -> return값 }

val sum = { a: Int, b: Int -> a+b}
// 어디든 타입을 한 번은 써줘야 컴파일러가 타입인지를 할 수 있다

//확장 함수
val pizzaIsGreat: String.() -> String = { this + "Pizza is best" }
// 함수이름 : String의 함수 타입 -> return 타입 = { this(이 함수가 포함된 String, 이 확장 함수를 호출하는 인스턴스) ...  }
// String에 새로운 함수를 추가한 것임. String에서 이 함수를 호출해 사용할 수 있음

fun extendString(name: String, age: Int) : String {
    val introduce: String.(Int) -> String = { "i am ${this} and ${it}" }
    // 파라미터가 하나일 때는 it이라는 예약어를 사용해서 파라미터를 사용할 수 있다.
    // String의 함수로 추가한 것인데 파라미터가 Int 타입이고 Return 타입은 String이다

    return name.introduce(age)
}

// 람다의 return
val calculateGrade: (Int) -> String = {

    // 람다는 제일 마지막 표현식이 return 이다
    when (it) {
        in 0..50 -> "fail"
        in 51..100 -> "pass"
        else -> "error"
    }
}

// 람다를 표현하는 여러가지 방법


fun main(){
    val result1 = square(2)
    println(result1)

    val added = sum(1, 5)
    println(added)

    val pineapple: String = "Pineapple"
    println(pineapple.pizzaIsGreat())

    val james: String = extendString("james", 20)
    println(james)

    val grade = calculateGrade(61)
    println(grade)

}


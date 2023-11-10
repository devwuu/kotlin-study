package joyce
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
fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
    // double을 받아서 boolean을 return하는 람다식을 파라미터로 받아서
    // 해당 람다식을 실행한다
    // 람다식에 5.2343를 넣어 실행한 값을 return 한다
    return lambda(5.2343)
}

fun invokeLambdaWithParam(lambda: (Int) -> Boolean, num: Int): Boolean {
    return lambda(num)
}

fun invokeLambdaWithParam2(num: Int, lambda: (Int) -> Boolean): Boolean {
    return lambda(num)
}

val lambda : (Double) -> Boolean = { it == 1.234 }
val lambda2 : (Int) -> Boolean = { it == 3 }


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

    // 람다를 표현하는 여러가지 방법
    // 이미 정의해둔 람다식을 파라미터로 넣어줄 수도 있다
    val isFalse = invokeLambda(lambda)
    println(isFalse)

    // 파라미터로 넣어질 람다를 바로 구현해서 적용할 수 있다
    val isTrue = invokeLambda { it == 5.2343 }
    println( invokeLambda(){it == 5.2343} )
    println( invokeLambda ({it == 5.2343}) )
    println(isTrue)
    // 똑같은 식
    // function의 유일한 파라미터가 람다식일 경우 소괄호 생략 가능
    // 람다식이 마지막 파라미터일 경우 람다식을 소괄호를 밖으로 빼서 작성할 수도 있다.

    println("------")

    val isFalse2 = invokeLambdaWithParam(lambda2, 2)
    println(" isFalse2 ${isFalse2}")
    val isTrue2 = invokeLambdaWithParam({ it == 2 }, 2)
//    invokeLambdaWithParam(2){it == 2} : 컴파일 에러
    println(" isTrue2 ${isTrue2}")

    val isFalse3 = invokeLambdaWithParam2(2, lambda2)
    println(" isFalse3 ${isFalse3}")
    val isTrue3 = invokeLambdaWithParam2(2, { it == 2 })
    println(" isTrue3 ${isTrue3}")
    val isTrue4 = invokeLambdaWithParam2(2) { it == 2 }
    println(" isTrue4 ${isTrue4}")

    // 위와 같은 방법으로 익명 내부 함수 구현이 가능합니다.



}


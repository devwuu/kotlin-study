package javaToKotlin

fun main() {

    val fruits = listOf(
        Fruits("사과", 1_000),
        Fruits("사과", 2_000),
        Fruits("사과", 3_000),
        Fruits("바나나", 4_000),
        Fruits("바나나", 5_000),
        Fruits("수박", 5_000),
    )

    // 함수 호출 법
    isApple(fruits[0])
    isApple.invoke(fruits[0])

    val filterFruits1 = filterFruits(fruits, isApple)

    // 람다식이 파라미터의 마지막에 있을 때 파라미터를 소괄호 밖에 적어줄 수 있다
    val filterFruits2 = filterFruits(fruits) { fruits -> fruits.name == "사과" }

    // 익명 함수, 람다식에서 파라미터가 한 개 일 경우 it이라는 예약어를 사용할 수 있다
    val filterFruits3 = filterFruits(fruits) { it.name == "사과" }
    // 근데 이렇게 쓰면 함수를 호출해서 사용하는 쪽에선 이 it이 무엇인지 예측하기 어렵기 때문에 명시적으로 선언해주는 것이 좋다

    println(filterFruits1)
    println(filterFruits2)

    // closure
    // 자바에서 람다를 사용할 때는 final인 변수만 가능하지만
    // 코틀린에서는 제약을 받지 않는다
    // 코틀린은 람다가 실행되는 시점의 변수들의 정보를 포획해서 가지고 있기 때문에 가능한 것
    // 이런 개념을 closure라고 한다
    var apple = Fruits("사과", 2_000)
    apple = Fruits("바나나", 2_000)
    filterFruit(apple){it.name == "바나나"}

}

// 익명 함수, 람다에 대해서

// 코틀린에서는 함수를 변수에 담을 수 있다 (자바는 불가능)
// 자바는 함수를 2급 시민으로 취급하지만 코틀린은 1급 시민으로 본다

// 익명 함수(fun 옆에 이름이 없음) 를 변수에 담은 것
// 이때 함수를 담은 변수의 타입은 파라미터 타입과 return 타입으로 정의된다
val isApple: (Fruits) -> Boolean = fun (fruits: Fruits): Boolean {
    return fruits.name == "사과"
}

val isApple2 = { fruits : Fruits -> fruits.name == "사과"}
val isApple3 = { fruits : Fruits ->
    println("사과 필터")
    fruits.name == "사과"
}
// 람다를 여러줄로 작성할 경우 return을 적어주지 않아도 자동으로 마지막 줄을 return 해준다

// 코틀린에서는 함수를 파라미터로 직접 받을 수가 있기 때문에 filter에 함수 타입을 적어주면
// 바로 사용할 수 있다
fun filterFruits (fruits :List<Fruits>, filter: (Fruits) -> Boolean): List<Fruits> {
    val list = mutableListOf<Fruits>()
    for ( fruit in fruits){
        if(filter(fruit)) list.add(fruit)
    }
    return list;
}

fun filterFruit (fruits :Fruits, filter: (Fruits) -> Boolean): Fruits? {
   return if(filter(fruits)) fruits else null
}

class Fruits (val name: String, val price: Int){

}
package javaToKotlin

// import ... as ...
// 임포트할 때 별칭을 지정해줄 수 있다
// 같은 이름의 함수를 한 파일에서 임포트하여 사용할 수 있게 한다
import javaToKotlin.a.hellowrold as helloA
import javaToKotlin.b.hellowrold as helloB

fun main() {
    helloA() // import ... as 에서 정한 알리아스로 함수 실행할 수 있다
    helloB()

    val person2 = Person2("james", 20)
    // 구조 분해
    val (name2, age2) = person2;
    val (age1, name1) = person2; // 프로퍼티 순서가 할당에 영향을 미친다
    println("${name2} : ${age2}") // james : 20
    println("${name1} : ${age1}") // 20 : james

     val person3 = Person3("jay", 20)
    // val (name3, age3) = person3; // data class가 아니라 일반 class 이기 때문에 구조 분해 불가
    // println("${name3} : ${age3}")

    // data class는 기본적으로 프로퍼티 갯수만큼 componentN이라는 함수를 만들어주는데
    person2.component1()
    person2.component2()
    // 이 함수가 구조분해에 사용된다
    // 즉 val (name2, age2) 에 선언된 변수는 변수 이름으로 프로퍼티가 분해 할당 되는 것이 아니고
    // 프로퍼티 순서에 의존해서 맵핑 되는 것이다

    // 따라서 componentN 함수가 만들어지지 않는 class의 경우엔 구조분해를 사용할 수 없다
    // person3.component1() // error

    // 만약 구조 분해를 사용하고 싶다면 직접 componentN 함수를 구현해서 구조 분해를 사용할 수 있다
    val person4 = Person4("kate", 30)
    val (name4, age4) = person4
    println("${name4} : ${age4}")

    println("-----")

    // return, break, continue
    val numbers = listOf(1, 2, 3)
    numbers.map { it+1 }
        .forEach {
            println(it)
            // continue
            // break
            // 기본적으로 forEach 문에서는 contine와 break를 사용할 수 없다
            // 기본적인 for문에서만 사용할 수 있음
        }

    // foreach 문에서 굳이굳이 continue와 break를 사용하고 싶다면...
    run {
        numbers.forEach {number ->
            if(number == 3) {
                return@run // == break
            }
            println(number)
        }
    }

    numbers.forEach {number ->
        if(number == 3) {
            return@forEach // == continue
        }
        println(number)
    }

    println("-----")

    // 라벨 : 특정 expression에 라벨이름@ 를 붙여서 하나의 라벨로 간주하고 break continue return 등을 사용하는 기능
    // 하지만 라벨을 사용한 jump는 되도록이면 사용하지 않는 것이... 코드가 복잡해진다
    loop@ for(i in 1..10){
        for (j in 1..10){
            if(j == 2) break@loop // break의 기본은 가장 가까운 루프를 멈추는 것이지만 여기선 loop로 라벨된 첫번째 for문을 멈춥니다
            println("${i} , ${j}")
        }
    }

    println("-----")

    for(i in 1..10){
        for (j in 1..10){
            if(j == 2) break
            println("${i} , ${j}")
        }
    }






}

// takeIf
// 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null이 반환된다
fun getNumberOrNull1(number: Int): Int? {
    return number.takeIf { i: Int -> i > 10 }
}

// takeUnless
// 주어진 조건을 만족하지 않으면 그 값이, 그렇지 않으면 null이 반환된다
fun getNumberOrNull2(number: Int): Int? {
    return number.takeUnless { i: Int -> i <= 10 }
}

// 타입 알리아스
typealias FruitFilter = (Fruit) -> Boolean
fun filterFruits3 (fruits :List<Fruit>, filter: FruitFilter): List<Fruit> {
    return fruits.filter(filter)
}

typealias USLCN = UltraSuperLongClassName
typealias USLCNMap = Map<String, UltraSuperLongClassName>
data class UltraSuperLongClassName (
    val name: String
){}


// 구조분해
data class Person2(
    val name: String,
    val age: Int
){}

class Person3(
    val name: String,
    val age: Int
){}

class Person4(
    val name: String,
    val age: Int
){
    // componentN 함수는 연산자 오버로딩으로 취급된다
    operator fun component1(): String{
        return name;
    }
    operator fun component2(): Int{
        return age;
    }
}



package javaToKotlin

fun main(){

    val name: String;
//    println(name) // 초기화 하기 전에 출력을 하려고 할 경우 에러가 발생한다
    name = "hello world" // val은 초기화 되지 않은 변수에 대해 최초 1번 값할당을 허용한다.
    println(name)

    val name2: String
//    println(name2) // var 역시 초기화 하기 전에 출력하려고 할 경우 에러가 발생한다

    // 모든 변수는 우선 val로 선언하고 꼭 필요한 경우 var로 변경한다

    // 코틀린은 박싱와 언박싱을 고려하지 않아도 괜찮을 정도로 자동으로 처리해준다
    // wapper classs는 referenced 타입으로 자바에서는 기본적으로 null이 가능하지만...
    val number1: Long = 10L
    val number2: Long = 1_000L
    // decompile
    // long number1 = 10L;
    // long number2 = 1000L;

    // 코틀린에서는 Nullable 로 지정해주지 않는 한 non-null 타입으로 정한다 (기본적으로 non - null)
    //null safe 하다
    var number3 = 1_000L
    // number3 = null //Null can not be a value of a non-null type Long
    var number4 : Long? = 2_000L
    number4 = null





}
package javaToKotlin

import javaToKotlin.javas.JavaMoney

fun main() {

    val javaMoney1 = JavaMoney(1_000L)
    val javaMoney2 = JavaMoney(2_000L)
    val javaMoney3 = JavaMoney(2_000L)

    if(javaMoney1 < javaMoney2){ // compareTo 메서드를 사용하지 않아도 비교 연산자가 자동으로 compareTo를 호출해준다
        println("javaMoney2이 더 큽니다")
        // comparedTo...
        // javaMoney2이 더 큽니다
    }

    // 동일성 ( === ) 주소까지 일치한다 (java의 == )
    // 동등성 ( == ) 값이 일치한다 (java의 equals)
    val money1 = KotlinMoney(1_000L)
    val money2 = KotlinMoney(1_000L)

    println("money1 == money2 : ${money1 == money2}")
    println("money1 === money2 : ${money1 === money2}")

    // equals를 자동으로 호출해서 동등성 비교를 해준다
    println("javaMoney2 == javaMoney3 : ${javaMoney2 == javaMoney3}")
    // equals...
    // true
    println("javaMoney2 === javaMoney3 : ${javaMoney2 === javaMoney3}")
    // 주소 비교이기 때문에 false가 나온다


    // Lazy 연산
    if(fun1() || fun2()){
        // fun1...
        // 본문
        // fun1 만 실행시켜도 true이기 때문에 굳이 fun2를 호출할 필요가 없음
        // 바로 본문 실행
        println("본문")
    }

    if(fun2() && fun1()){
        // fun2...
        println("본문")
        // fun2에서 이미 false 이기 때문에 fun1을 실행시키지 않고 바로 탈출해버림
    }

    if(fun1() && fun2()){
        // fun1...
        // fun2...
        // fun1이 true이기 때문에 fun2 까지 실행한 다음에 탈출함
        println("본문")
    }

    // 이 외에도 in, !in, a..b, a[i], a[i] = b 등의 연산자가 있다

    // 코틀린은 연산자 오버로딩이 가능하다
    val money3 = Money(1_000L)
    val money4 = Money(2_000L)
    println(money3 + money4)
    // operator fun,,,
    // Money(money=3000)


}

fun fun1(): Boolean{
    println("fun1...")
    return true
}

fun fun2(): Boolean{
    println("fun2...")
    return false
}

data class Money(val money: Long){
    // 연산자 오버로딩
    operator fun plus(other: Money): Money{
        println("operator fun,,,")
        return Money(this.money + other.money)
    }
}

class KotlinMoney(val money: Long){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KotlinMoney

        return money == other.money
    }
}
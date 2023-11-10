package javaToKotlin

fun main() {
    validateIsNotNegative(100)
    println(getPassOrFail(50))
    println(getGrade(60))
    println(startWithA("Apple"))
    println(startWithA(20))
    judgeNumber(-1)
    judgeNumber2(20)
}

fun validateIsNotNegative(number: Int): Unit{
    if (number < 0) throw IllegalArgumentException("${number} cannot be negative")
    else println("number is ${number}")
}

// statement : 프로그램의 한 문장. 하나의 값으로 도출되지 않음
// expression : statement 중 하나의 값으로 도출되는 문장
// java의 if는 statement지만 kotlin은 expression이다

fun getPassOrFail(number: Int): String{
//    val result = if (number <= 50) "F"
//    else "P"
//    return result

    return if (number <= 50) "F"
    else "P"
    // 이렇게 사용할 수 있기 때문에 삼항 연산자가 필요없음 (그래서 없음)
}

fun getGrade(number: Int): String{

    return if(number <= 50){
        "F"
    }else if(number in 51..80){
        // 51 <= number <= 80
        // in 범위
        // 범위는 a..b 연산자를 이용해 이상 이하를 표현해줄 수 있다
        "B"
    }else if(number in 80..<99){
        // .. 뒤로 < 를 붙여서 미만을 사용할 수 있다
        "A"
    }
    else {
        "S"
    }

}

fun getRank(number: Int): String{
   return when(number){
       in 0..30  -> "D" // when에 적어준 변수와 조건문이 합쳐져서 하나의 조건문
       in 31..100 -> "A"
       else -> "F"
    }
}

fun startWithA(str: Any): Boolean{
    return when(str){
        is String -> str.startsWith("A") // when의 조건문에는 어떤 statement든 올 수 있다
        else -> false
    }
}

fun judgeNumber(number: Int){
    when (number){
        -1, 0, 1 -> println("어디서 많이 봤습니다") // when 조건문에는 여러가지 조건을 나열할 수도 있다
        else -> println("낯섭니다")
    }
}

fun judgeNumber2(number: Int){
    //when에 아예 변수를 주지 않고 조건문에서 풀 조건을 써줄 수도 있다
    when {
        number % 2 == 0 -> println("짝수입니다")
        else -> println("홀수입니다")
    }
}
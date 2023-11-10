package javaToKotlin

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)

    // 향상된 for문
    for(number in numbers){
        println(number)
    }

    // 전통적인 for문
    // 여기서 ..을 사용하면 1부터 4까지 순차적으로 올라간다
    for (i in 0..4){
        println(numbers.get(i))
    }
    // 거꾸로 내려가고 싶다면 downTo
    for (i in 4 downTo 0){
        println(numbers[i])
    }
    // 특정한 등차를 적용하고 싶다면 step
    for (i in 0..4 step 2){
        println(numbers[i])
    }

    // .. 연산자 : 범위 연산자
    // a..b : a 이상 b이하

    // progression(등차수열)을 상속받은 range(범위)타입 을 만들어주고 있는 것
    // 범위를 만드는데 처음 값이 a이고 끝 값이 b인 공차(step)가 1인 등차수열을 만들어주는 것
    // downTo, step도 함수이다 (중위함수)

    // 1. a가 시작값, b가 끝값인 등차수열 (공차 = 1 )을 만든다
    // 2. step이 있다면 step 함수를 호출해서 새로운 공차를 적용한다
    // 3. 지정한 공차를 가진 등차 수열을 완성한다

    // while
    var idx = 1
    while (idx < 3){
        println("idx ${idx}")
        idx ++
    }

}
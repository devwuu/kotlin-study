package joyce

fun main(){
//    checkNumber(0)
//    checkNumber(10)
    checkNumber(41)
}

fun maxIs1(a: Int, b: Int): Int{
    if(a>b){
        return a;
    }else{
        return b;
    }
}

// 마치 라잌 삼항연산자
fun maxIs2(a: Int, b: Int): Int = if (a>b) a else b;

// 코틀린에서는 삼항연산자가 지원되지 않고 대신 위 처럼 씁니다
//fun  maxIs3(a: Int, b: Int): Int{
//    return (a>b) ? a : b
//}

fun checkNumber(a: Int){
    // 마치 라잌 swith - case 문
    //statement
    when (a){
        0 -> println("is 0")
        1 -> println("is 1")
        2, 3 -> println("is 2 or 3") // 둘 중 하나
//        else -> println("not 0, 1, 2, 3") // 어떤 것도 해당되지 않는 경우, 생략 가능
    }

    //expression
    var b: String = when(a){
        0 -> "is 0"
        1 -> "is 1"
        2, 3 -> "is 2 or 3" // 둘 중 하나
        else -> "not 0, 1, 2, 3" // 생략 불가능. 변수에 할당할 때는 꼭 else를 써줘야 한다
    }

    println(b)

    when(a){
        in 0..10 -> println("a is in 0 ~ 10"); // 범위를 사용하고 싶을 때는 in a..b 을 사용한다 (이상 이하)
        in 11..20 -> println("a is in 11 ~ 20")
        in 30..40 -> println("a is in 30 ~ 40")
        else -> println("else") // 21 ~ 29, 41~ 은 else로 빠진다 위 세 조건 중 어디에도 해당되지 않음
    }

}

//expression Vs statement
// 값을 만드는 경우 -> expression
// 단순히 선언만 되는 경우 -> statement
// 단, 코틀린에서 모든 함수는 expression이다 ( return값이 없더라도 Unit을 리턴하기 때문에)
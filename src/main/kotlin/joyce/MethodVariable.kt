package joyce

fun main(){
    helloWorld()
    helloKotlin()
    println(add(3,5))
    typeCheck()
}

// 1. 함수를 정의하는 법
// fun 함수이름() : 리턴타입 { ... }
// return이 없는 경우엔 Unit을 써준다. (void 같은 거임.) Unit은 생략이 가능하다
// 리턴이 있는 경우엔 작성이 필요하다( 리턴타입 생략이 불가능하다)
fun helloWorld(): Unit {
    println("hello world")
}
fun helloKotlin() {
    println("hello kotlin")
}
//fun helloInt() {
//    return 1;
//}

// 타입은 변수 뒤에 정의해준다
// Int도 int가 아니라 Int 이다.
fun add(a: Int, b: Int): Int{
    return a+b
}

// 1. val VS var
fun value(){
    val a = 10
    // a = 20; // val(value)은 재할당 할 수 없다 ( 상수)
    var b = 20
    b = 30 // var(variable)은 재할당 할 수 있다
}

// 2. 타입 자동 추정
fun typeCheck(){
    val a = 10; // 값을 바로 할당할 때 타입 자동 추론이 가능하다
    val b: String = "hello";
    println(a is Int);
    println(b is String);

    var c = 10;
    println(c is Int);
    // c = "string"; //var 타입이지만 10으로 할당되어 Int로 타입이 정해짐.
    // 따라서 문자열 재할당이 불가능하다 ( Type mismatch)

    var username: String = "hello"; // 타입을 명확하게 적어줘도 된다
    println(username is String)

    var d: String;
//    var e; // 값을 바로 할당하지 않으면 타입 자동 추론이 불가하기 때문에 명확하게 타입을 적어줘야 한다.

}
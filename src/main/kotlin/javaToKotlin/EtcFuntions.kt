package javaToKotlin

// 확장 함수
// 코드는 클래스 밖에 있지만 꼭 클래스의 멤버 함수처럼 사용할 수 있게 하자

// fun 확장할클래스.함수이름 : 반환타입 { //본문 }
fun String.lastChar() : Char {
    // 여기서 this는 대상이 된 String instance(값)을 가리킨다
    // this : 수신객체, 확장하려는 클래스: 수신객체타입
    return this[this.lastIndex]
    // 확장 함수에서는 클래스에 있는 private, protected 멤버를 가져올 수 없다
    // public, internal만 가능
}

// 확장함수의 이름과 본래 멤버 함수의 이름이 겹치게 된다면?
fun Origin.printStr(){
   println("ABC")
}

open class Origin{
    fun printStr(){
        println("hello world!")
    }
}

class Sub : Origin()

// 확장 함수가 오버라이드 된다면?
fun Origin.hasNumber () : String{
    return "origin number is ${100}"
}
fun Sub.hasNumber() : String{
    return "sub number is ${300}"
}

// 확장 프로퍼티도 가능하다
// 외부에서 custom getter를 만드는 것처럼 만들 수 있다
val Sub.name : String
    get() = "SUB NAME"

// 중위 함수
// 새로운 함수를 호출할 수 있게 해준다
// 변수 함수이름 arg 로 호출할 수 있게 해준다
// 단 이때 파라미터는 1개여야 한다
// infix 키워드를 사용한다
// 이렇게 확장 함수에도 붙일 수 있고 멤버 함수에도 붙일 수 있다
infix fun Int.adds(other: Int): Int {
    return this + other
}

// inline 함수
// 함수를 호출 하는 대신 함수 본문을 그대로 복사 붙여넣기 하고 싶은 경우 ??
inline fun Int.minuses(other: Int): Int {
    return this - other
}

// 지역함수
class Snacks(name: String, company: String)
fun createSnacks(name: String, company: String): Snacks{

    // 지역함수. 이 함수 안에서만 사용할 수 있는 함수가 된다
    // 중복되는 코드를 함수로 만들어서 사용
    // 근데 depth가 깊어지기도 하고 코드가 엄청 깔끔해보이는 것도 아니다...
    fun validateStr(value: String, fieldName: String){
        if ( value.isEmpty() ) throw IllegalArgumentException("${fieldName} 은 비어있을 수 없습니다")
    }

    validateStr(name, "name")
    validateStr(company, "company")

    return Snacks(name, company)
}


fun main() {
    val name1 = "james"
    println(name1.lastChar())
    val origin = Origin()
    origin.printStr()
    // hello world!
    // 멤버 함수가 호출되게 된다
    // 함수의 시그니처가 동일하게 되면 멤버 함수가 호출되게 된다

    val sub1 : Origin = Sub()
    val sub2 : Sub = Sub()
    println(" origin : ${origin.hasNumber()}") // origin : origin number is 100
    println(" sub1: ${sub1.hasNumber()}") // sub1: origin number is 100
    println(" sub2: ${sub2.hasNumber()}") // sub2: sub number is 300
    // 변수 타입에 의존해서 호출되는 결과가 달라진다
    // 정적 타입에 의존해 호출되는 결과가 달라진다

    // 확장 프로퍼티
    println(sub2.name)

    // 중위함수
    println(3 adds  4)

    // inline 함수
    3.minuses(1)
    // int var10000 = $this$minuses$iv - other$iv;
    // 함수를 실행하는 로직이 아니라 빼기 로직 그 자체가 들어오게 된다
    // 함수를 파라미터로 사용할 때 오버헤드를 줄일 수 있어서 사용하는건데
    // 성능 측정과 함께 신중하게 사용돼야 합니다

    // 지역함수
    // 함수 안에 함수를 선언할 수 있다

    // createSnacks("새우깡", "") //company 은 비어있을 수 없습니다

}


// 자바코드가 있는 상황에서 코틀린으로 추가 개발을 하기 위해 확장 함수와 확장 프로퍼티가 생겼다
// 확장 함수는 원본 클래스의 protected, private 멤버에는 접근이 불가하다
// 확장 함수와 멤버 함수의 시그니처가 겹칠 경우 멤버 함수가 우선권을 갖는다
// 확장 함수의 오버라이딩은 변수 타입(현재 타입)에 의해 결정된다

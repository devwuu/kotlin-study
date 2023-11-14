package javaToKotlin

// data class
// 계층간의 데이터를 전달하기 위한 DTO
// 데이터(필드), 생성자와 getter, equals, hashcode, toString을 자동으로 포함하고 있음
// java 에서는 jdk 16이상을 사용하지 않는 한 class 코드가 장황해지기 마련인데... 코틀린은 깔끔하다

data class PersonDto(
    val name: String,
    val age: Int
)

fun main() {
    val james1 = PersonDto("james", 10)
    val james2 = PersonDto("james", 10)
    val jenny = PersonDto("jenny", 10)
    println(james1.toString())
    println(james1 == james2)
    println(jenny == james1)
}

// enum class
// enum은 상속이 불가하며 기본적으로 싱글톤이다
// new Country.KOREA (XX)
enum class Country(private val code: String){
    KOREA("KO"),
    AMERICA("US"),
    FRANCE("FR")
}

fun handleCountry(con: Country){
    when(con){
        Country.KOREA -> println("한국")
        Country.AMERICA -> println("미국")
        Country.FRANCE -> println("프랑스")
        // else 를 작성해줄 필요가 없다. 어차피 enum에 다른 값이 들어올 리가 없기 때문에...
        // enum에 다른 코드가 추가되면 그때 컴파일 에러가 발생함
    }
}

// sealed class
// 상속이 가능한 추상클래스, 하지만 외부에서 이 클래스를 상속받을 수 없음
// 하위 클래스를 특정 클래스만 존재하도록 봉인할 수 있음
// ** 컴파일 타임에 하위 클래스 타입을 모두 기억하며 런타임에 클래스가 추가될 수 없다 ** => enum과 유사하지만 상속이 가능한 구조
// 하위 클래스는 같은 패키지 안에 있어야 한다
// 하위 클래스는 멀티 인스턴스가 가능하다
// 추상화가 필요한 entity나 DTO에는 sealed class를 사용한다
// jdk 17에도 이와 유사한 클래스가 추가되었다

sealed class Animals(val name: String)
class Dogs : Animals("dog")
class Cats : Animals("cat")
class Bird : Animals("bird")


fun handleAnimals(animals: Animals){
    when(animals){
        is Dogs -> println("강아지")
        is Cats -> println("고양이")
        is Bird -> println("새")
        // else 를 써주지 않아도 됨
        // 해당 sealed class를 상속받을 class 가 추가될 때마다 컴파일 에러가 발생함
    }
}
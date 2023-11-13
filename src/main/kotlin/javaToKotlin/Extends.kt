package javaToKotlin

// 자바와 마찬가지로 코틀린에서도 추상 클래스는 인스턴스화 할 수 없다
abstract class Animal (
    val species: String,
    open val legCount: Int
){
    abstract fun move()
}

// code convention
// 상속을 표현할 때는 class 이름 : 부모클래스 {}
// 타입을 표현할 때는 val 변수이름: 타입
// : 앞에 공백이 있는지 없는지 확인한다
class Cat(species: String) : Animal(species, 4){ // super()를 호출해준다
                                                    // species는 Cat의 생성자에서 전달받은 값이고
                                                    // legcount는 호출시 지정해서 넘겨준 값임
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어갑니다")
    }

}

// 상속을 받을 때도, 구현을 할 때도 : 을 사용한다
class Penguin(species: String) : Animal(species, 2), Swimable, Flyable{

    private val wingCount: Int = 2

    // abstract이 아닌 클래스, 필드, 메서드는 모두 open을 해줘야 override 할 수 있다 ( 인터페이스 예외)
    // getter override
    override val legCount
        get() = super.legCount + this.wingCount
    // 상위 클래스는 super

    override fun move() {
        println("펭귄이 움직입니다~")
    }

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override fun swim() {
        println("펭귄이 수영을 합니다")
    }

    override fun fly() {
        println("펭귄이 날아갑니다")
    }

    override val ability: Int
        get() = 3

}

// 인터페이스는 인터페이스화 할 수 없다
// 인터페이스에는 backing field가 없는 프로퍼티를 만들 수 있다
interface Flyable{
    // 디폴트 함수
    fun act(){
        println("파닥파닥")
    }
    // 추상메서드
    fun fly()
}

interface Swimable{

    val ability: Int // 구현체에서 getter를 구현해야 합니다
    val depth: Int
        get() = 1 // 구현체에서 getter를 구현하지 않아도 됩니다
                    // override해도 됨
    fun act(){
        println("ability : ${ability}") // 구현체에서 getter를 구현할 것이라고 믿고(구현이 필수임) 사용할 수 있습니다
        println("depth : ${depth}") // default 구현이 이미 되어 있기 때문에 편하게 가져다가 사용할 수 있습니다
        println("어푸어푸")
    }
    fun swim()
}



// 상위 클래스를 설계할 때
// 생성자 또는 초기화 블럭에 사용되는 프로퍼티는 open을 피해야한다
// 어떤 값이 나올지 모르기 때문
open class Base(
    open val number: Int = 100,
    val name: String
){
    init {
        println("base class : number ${number}") // Accessing non-final property number in constructor
        // 자식 생성자가 실행되면서 number값이 정해질 수도 있는데 ( final이 아니기 때문)
        // 부모에서 먼저 number에 접근하면
        // number가 초기화가 되지 않아 int이 기초값인 0이 출력된다
        println("base class : name ${name} ")
        // final의 경우 이미 부모의 init 블록에서 값이 확정되기 때문에
        // 접근해도 상관없음
    }
}

class Derived(
    override val number: Int
) : Base(number, "hello"){
    init {
        println("derived class : number ${number}")
    }
}

fun main() {
    Derived(20)
    //base class : number 0
    //derived class : number 20
    // 자식의 init 블록에서 number 값이 초기화 되는데 자식 init 블록 전 부모의 init 블록이 먼저 수행되어서
    // number가 초기화 되지 않고 int의 기본값이 나옴
}


// 추상멤버(인터페이스, abstract)가 아니라면 클래스, 프로퍼티, 메서드는 기본적으로 모두 final이다
// override를 허용하려면 open 키워드를 붙여줘야 한다
// open 키워드가 붙은 클래스, 프로퍼티, 메서드는 override가 optional하다
// abstract은 반드시 override 해야한다
// override는 상위 타입을 오버라이드 한다
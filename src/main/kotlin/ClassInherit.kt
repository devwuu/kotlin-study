open class Person{
    fun eating(){
        println("냠냠")
    }
    open fun playing(){
        println("랄라")
    }
    open fun shopping(){
        println("우유")
    }
}

// 코틀린의 클래스는 기본적으로 final이기 때문에 상속받을 수 없음
// 상속을 받게 해주려면 open 키워드를 사용해야 함
class Korean : Person() {

    // 메서드도 final 이기 때문에 open 해줘야 함
    override fun playing(){
        println("랄랄라")
    }

    override fun shopping() {
        super.shopping() // super 키워드로 부모 클래스에 접근할 수 있다
        println("피자")
    }
}

open class Car(val name: String){
    fun go(){
        println("부릉부릉")
    }
}

// 부모 생성자에 전달해줘야 하는 파라미터가 있을 경우 자식도 반드시 그 파라미터를 받아야 한다
class Bus(name: String) : Car(name){
    init {
        println("new Bus!")
    }
    constructor(): this(name="default"){
        println("default Bus!")
    }
}

// default가 설정 돼있다면 해당 default로 파라미터가 설정된다
open class Cheese(val name: String = "default cheese"){

}

class Pizza : Cheese(){
}

fun main(){
    val korean = Korean()
    korean.eating(); // 상속
    korean.playing(); // 오버라이딩
    korean.shopping()

    val bus1 = Bus("마을버스");
    bus1.go()
    println(bus1.name)// 마을버스
    val bus2 = Bus();
    println(bus2.name) //default

    val pizza = Pizza();
    println(pizza.name) // default cheese

}
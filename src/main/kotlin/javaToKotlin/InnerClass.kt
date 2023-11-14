package javaToKotlin


// 코틀린은 기본적으로 내부 class를 정의할 때 static한 내부 클래스로 정의해준다
// => 바깥 클래스를 직접 참조하지 않는 클래스로 정의해준다
class House(
    val address: String,
    val livingRoom: LivingRoom
){
    class LivingRoom (
        val area: Double
    )
}

// 바깥 class를 참조하는 (권장되지 않는) 클래스를 만들기 위해서는 inner라는 키워드를 선언해주고
// this@바깥클래스.~~로 접근한다
class House2(
    val address: String,
    val livingRoom: LivingRoom
){
    inner class LivingRoom (
        val area: Double
    ){

        val address: String
            get() = this@House2.address

    }

}

// 즉, 코틀린에서는 기본적으로 내부 클래스가 외부 클래스를 참조하지 않게 설계되어 있고
// 굳이 바깥 클래스를 참조하고 싶다면 inner 키워드 + this@바깥클래스.~~를 사용해야한다
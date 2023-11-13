package javaToKotlin

class Student(
    var name: String,
    var age: Int
){
    // static 멤버 선언
    // 정적 멤버 선언
    // static이 인스턴스가 생성될 때 새로운 값이 복제되는 게 아니라 인스턴스가 서로 공유하는 정적 영역이듯이
    // companion object도 클래스와 동행하는 유일한 오브젝트이다 (정적인)
    // 인스턴스가 여러개 생성되도 동행한다
    companion object {
        private const val MIN_AGE: Int = 18 // const ? 컴파일 타임에 변수에 할당된다
                                // val은 런타임에 변수에 할당이 된다
                            // 따라서 const는 진짜 상수에만 붙이는 키워드이고 기본타입과 String에만 붙일 수 있다
        fun newStudent(name: String): Student{
            return Student(name, MIN_AGE)
        }
    }
}

class Teacher {

    // companion object는 하나의 객체로 취급된다
    // 따라서 인터페이스를 구현할 수도 있고 이름을 붙여줄 수도 있다
    companion object Factory : Log{
        @JvmStatic
        override fun log() {
           println("teacher의 companion object 입니다")
        }

    }
}

interface Log {
    fun log()
}


// object 키워드를 사용하여 singleton을 만들 수 있다
object Singleton{
    var a: Int = 0
}

fun main() {

    // companion object를 사용하는 방법
    Teacher.Factory.log()
    Teacher.log()
    Student.Companion.newStudent("student1") // companion object에 이름이 없을 때는 Companion이 기본값이다
    Student.newStudent("student2")

    println(Singleton.a)
//    Singleton() ==> 컴파일 에러
    Singleton.a = 10
    println(Singleton.a)

    // 익명 클래스를 사용하는 방법
    // object : 구현할클래스 { // 내용 }
    moveSomething(object : Movable {
        override fun move() {
            println("움직여요")
        }
        override fun fly() {
            println("날아요")
        }
    })

}

fun moveSomething(movable: Movable){
    movable.move()
    movable.fly()
}

interface Movable{
    fun move()
    fun fly()
}
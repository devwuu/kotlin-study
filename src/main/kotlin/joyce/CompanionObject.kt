package joyce

// 컴패니언 오브젝트
// 정적 메서드나 정적 필드를 선언하기 위해 사용한다 ( java의 static)
class Book1 private constructor(val id:String, val name:String){
    companion object{
        val created: String = "2021-01-01"
        fun create() = Book1("a", "a book")
    }
}

class Book2 private constructor(val id:String, val name:String){
}

class Book3 private constructor(val id:String, val name:String){

    // 컴패니언 오브젝트는 이름도 정해줄 수 있고 상속(구현)도 할 수 있다.
    companion object BookFactory : IdProvider {
        val created: String = "2021-01-01"
        fun create() = Book3("a", "a book")
        override fun generateId(): String {
            return "b"
        }
    }
}

interface IdProvider{
    fun generateId() : String
}


fun main(){
    val book1 = Book1.create()
//    Book1.Companion.create() 의 단축
    println("boo1: ${book1.id}, ${book1.name}, ${Book1.created}")
//    Book2("a", "a book") 생성자의 접근자가 private 이기 때문에 클래스 외부에서 사용 불가
    println(Book3.generateId())
    println(Book3.generateId())
    // 컴페니언 오브젝트의 이름을 정해주게 되면 해당 이름으로 정적 멤버를 호출해야 함
}

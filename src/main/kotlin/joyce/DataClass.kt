package joyce
// 데이터 클래스
// DTO로 사용할 수 있다
// ToString,  Hashcode, equals, copy 메서드를 개발자가 직접 만들지 않아도 자동으로 만들어준다
// 한 파일에 여러 클래스를 정의할 수 있는 코틀린의 특성을 이용해 연관 있는 클래스를 한꺼번에 한 파일에 정의해서 관리할 수 있다
data class Ticket1(
    val companyname: String,
    val client: String,
    var date: String,
    var seat: Int
){}

class Ticket2(
    val companyname: String,
    val client: String,
    var date: String,
    var seat: Int
){}

fun main(){
    val ticket1 = Ticket1("korean air", "james", "20230101", 14)
    val ticket2 = Ticket2("korean air", "james", "20230101", 14)

    println(ticket1) // Ticket1(companyname=korean air, client=james, date=20230101, seat=14)
    println(ticket2) // Ticket2@5b464ce8

}
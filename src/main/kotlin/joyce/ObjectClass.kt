package joyce
// object는 singleton pattern으로 만들어진다
// 애플리케이션이 실행될 때 한 번 객체를 만들고 다시 만들지 않는다
object StudentFactory {
    val students = mutableListOf<Student>()
    fun generateStudent(name:String): Student {
        val student = Student(name)
        students.add(student)
        return student
    }
}

data class Student (val name:String)

fun main(){
    StudentFactory.generateStudent("james")
    StudentFactory.generateStudent("jenny")
    println(StudentFactory.students.size)
}
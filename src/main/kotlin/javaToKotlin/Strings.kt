package javaToKotlin

fun main() {

    val name= "james"
    println("my name is ${name}")
    println("my name is $name")

    // 여러줄의 문자를 """을 이용해서 작성할 수 있다
    val text = """
        hello,
            world!
        ${name}
    """.trimIndent() // .trimIndent() : 코드상의 들여쓰기 제거
    println(text)

    println(name[1]) // 문자열을 마치 배열처럼 []를 이용해서 문자열을 가져올 수 있다

}
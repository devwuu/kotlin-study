package javaToKotlin

fun main() {
    repeat("hello")
    repeat("hello", useNewLine = false)
    // named argument
    // 어떤 파라미터에 값을 넣을건지 지정 가능
    // 값이 지정되지 않은 파라미터는 default 값을 사용한다

    printNameAndGender(gender = "F", name = "james")
    // named 파라미터를 사용하면 같은 타입의 파라미터도 순서 헷갈리지 않고 잘 넣어줄 수가 있다
    // 단, java로 만들어진 함수를 가져다 쓰려고 하려면 named arguments를 사용할 수 없다

    printArguments("jane", "james", "jenny")
    val args = arrayOf("jane", "james", "jenny")
    printArguments(*args)
    // 배열을 바로 넣지는 못하고 * (스프레드 연산자)를 붙여서 사용해줘야 한다
    // js의 ... 과 동일한듯
}

// 함수는 한 파일에 여러개 작성할 수 있다
// 함수는 클래스 안에 작성할 수 있다

// if는 expression이기 때문에 바로 return 해줄 수 있다
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
// 함수가 하나의 결과값이면 중괄호를 생략하고 압축해서 표현할 수 있다
// 중괄호가 생략이 되어있고 파라미터 타입이 다 지정이 돼있기 때문에(결과값 예측 가능) return type도 생략할 수 있다
// 중괄호가 생략돼있지 않으면 return type을 꼭 적어줘야 한다
fun max1(a: Int, b: Int) = if( a > b) a else b

// default 파라미터를 이용해서
// 파라미터 갯수가 1개인 함수,
// 파라미터 갯수가 2개인 함수를 모두 하나의 함수로 구현할 수 있다
fun repeat(str: String, number: Int = 3, useNewLine: Boolean = true){
    for (i in 1..number){
        if(useNewLine) println(str)
        else print(str)
    }
}

fun printNameAndGender(name:String, gender:String){
    println("name: ${name} gender: ${gender}")
}

// 가변인자는 vararg 키워드를 사용함
fun printArguments(vararg strs: String){
    // 받아지는 건 배열로 받아지기 때문에 iterator 사용
    for (str in strs){
        println(str)
    }

}
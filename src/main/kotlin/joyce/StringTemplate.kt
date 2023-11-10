package joyce

fun main(){
    val hello = "hello";
    val world = "world";
    println("my name is $hello $world !!") // string template
    println("my name is ${hello + world}!!") // string template
    // 띄어쓰기 여부에 따라 중괄호를 추가 혹은 생략할 수 있다.
    //js랑 동일함

    println("\$hi"); // $를 문자열로 사용하고 싶으면 escape 문자열을 사용하면 된다

}
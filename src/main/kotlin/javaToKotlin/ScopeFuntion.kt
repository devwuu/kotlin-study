package javaToKotlin

fun main() {

    val person5: Person5 = Person5("jay", 30)

    // scope function의 종류
    // let, run, with => 람다의 결과를 반환함
    // also, apply, => 객체 그 자체를 반환함

    // let, also => it 사용 가능
    // run, apply, with => it 사용 불가. this 사용 가능

    // it은 생략이 불가능한 대신 다른 이름을 붙일 수 있다
    // this는 생략이 가능한 대신 다른 이름을 붙일 수 있다

    // it을 사용하는 케이스는 함수를 직접 파라미터로 받기 때문이고
    // this를 사용하는 케이스는 확장 함수를 받기 때문이다

    val let = person5.let { it.age }
    println("${let}") // 30

    val run = person5.run { this.age }
    println("${run}") // 30

    // it은 생략이 불가능한 대신 다른 이름을 붙일 수 있다
    person5.let { person5: Person5 -> person5.age }
    // person5.let { age } it은 생략이 불가능

    // this는 생략이 가능한 대신 다른 이름을 붙일 수 있다
    person5.run { name }
    // person5.run { person5: Person5 -> person5.age }
    // this는 다른 이름으로 대체 불가


    val also = person5.also { it.age }
    println("${also}") // Person5(name=jay, age=30)

    val apply = person5.apply { this.age }
    println("${apply}") // Person5(name=jay, age=30)

    // with는 확장 함수가 아니기 때문에 혼자 문법이 조금 다르다
    val with = with(person5) { age }
    with(person5){ this.age }
    // with(person5){ person5: Person5 -> person5.age }
    println("${with}") //30


    // let 용례
    // 하나 이상의 함수를 call chain 결과로 호출할 때
    val persons = listOf(
        Person5("jake", 20),
        Person5("kate", 30),
        Person5("jake", 30),
        )
    persons.map { it.name }
        .filter { s -> s == "jake" }
        .let (::println)

    // non-null인 케이스에만 code block을 실행시키고 싶을 때
    persons?.let { println(it) }

    // 일회성으로 제한된 영역에 지역 변수를 만들 때
    val oldAge = persons.first()
        .let { person5: Person5 -> person5.age + 100 }

    // run의 용례
    // 객체 초기화와 반환 값 계산을 동시에 해아할 때
    val repository = Repository()
    val saved1 = Person5("kate", 20).run { repository.save(this) }
    val saved2 = Person5("kate", 20).run {
        this.name = "jame"
        repository.save(this)
    }
    println(saved1)
    println(saved2)

    // apply 용례
    // test feature 작성할 때
    createPerson("james", 10, "piano")
    // 객체 프로퍼티를 중간에 바꿔야할 때나 함수를 호출해야할 때
    Person5("kate", 20).apply {
        this.growOld()
    }.let { println(it) }

    // also의 용례
    // 객체를 수정하는 로직이 call chain 중간에 필요할 때
    mutableListOf("one", "two")
        .also { println(it) }
        .add("three")

    // with의 용례
    // 특정 객체를 다른 객체로 변환해야하는데 모듈간의 의존성에 의해
    // 정적 팩토리 또는 toClass 함수를 만들기 어려울 때
    val dto = with(person5) {
        Person5Dto(name = name, age = age)
    }
    // this를 생략할 수 있기 때문에 간단해진다


}

// scope function
// 람타를 사용해서 일시적인 영역을 만들고
// 코드를 더 간결하게 만들거나 method chaining 에 활용하는 함수를 일컫는다
fun printPerson(person5: Person5?){
    // safe call을 이용해서 null이 아닐 때 let 영역이 실행되게 만듦
    person5?.let {
        println("name: ${person5.name}, age: ${person5.age}")
    }
}


// apply 용례
fun createPerson(name:String, age: Int, hobby: String): Person5{
    return Person5(name, age)
        .apply { this.hobby = hobby }
}



data class Person5(
    var name: String,
    val age: Int
){
    var hobby:String = ""
    fun growOld(){
        age + 100;
    }
}

data class Person5Dto(
    var name: String,
    val age: Int
){
}

class Repository{
    fun save(person5: Person5): Person5{
        return person5;
    }
}

// scope function 사용시 고려해야하는 사항
// 가독성이 좋은가? (많은 사람들이 이해하기 쉬운가?)
// 디버깅 하기 쉬운가?
// 추가 요구사항이 반영되기 쉬운가?
// scope function을 미친들이 chaining 해두면... 쉽지 않겠지...
// 따라서 적절한 convention이 필요하다
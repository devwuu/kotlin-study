package javaToKotlin

fun main(){
    // 코틀린에서는 선언된 값에 따라 타입을 자동으로 추론해준다
    var number1 = 3 // Int
    var number2 = 3L // Long
    val number3 = 0.3f // float
    val number4 = 0.3 // double

    // 코틀린에서는 타입 변경을 명시적으로 해줘야 한다
    //number2 = number1 // Type mismatch로 컴파일 에러
    number2 = number1.toLong()
    // 코틀린에서 타입 변환은 .to타입() 함수를 호출해서 한다

    // nullable 변수라면 타입 캐스팅을 할 때도 적절한 처리가 필요하다
    var number5: Int? = 3;
    // number5.toLong() // safe call 이 아니라서 에러
    val number6: Long= number5?.toLong() ?: 0
    // ?. ?: 연산자를 이용해서 적절한 처리가 가능하다


    // printName3(Male("hello")) // 타입캐스팅 에러
    printName2(Male("hello")) // null
    printName2(null) // null
    printName2(Person("world")) // world

}

fun printName(obj : Any){
    if( obj is Person) {
        // is ( == instanceof 와 동일한 키워드)
        // 객체가 해당 타입인지 검증
        val person =  obj as Person
        // as (타입) 캐스팅과 동일
        // 특정 타입으로 인스턴스 변환
        println(person.name)

        // 근데 as 를 하지 않고도 바로
        println(obj.name)
        // 이렇게 사용할 수 있다
        // is 로 인스턴스 검증을 했기 때문
        // 스마트 캐스트
    }

    if(obj !is Person){
        // obj 가 Person 타입이 아닌 경우
    }

}

fun printName2(obj: Any?){
    val person = obj as? Person
    // 만약 nullable 한 파라미터라면 as? 를 이용해서 nullable Person으로 선언해준다
    // 타입 캐스팅이 불가능한 경우, null인 경우 null을 반환한다
    // 약간 safe call 처럼 작동한다
    println(person?.name)
}


fun printName3(obj: Any){
    val person = obj as Person // 캐스팅 하기 전에 instance 인지 확인해줘야한디
    // 타입 캐스팅이 불가할 경우 타입 캐스팅 에러가 런타임에 발생한다 (ClassCastException)
    // class javaToKotlin.Male cannot be cast to class javaToKotlin.javas.Person
    println(person.name)
}

class Person(val name: String) {

}

class Male(val name:String){

}
class Human constructor(age: Int){ // 주생성자 선언
    val name = "james"
    val age = age;
    fun eatingCake(){
        println("케이크 냠냠")
    }
}

class Male constructor(val age: Int){ // 생성자에 val / var 키워드까지 선언해주면 필드에 직접 초기화 하지 않아도 자동으로 초기화 된다
    val name = "james"
    fun eatingCake(){
        println("케이크 냠냠")
    }
}

class Female (val age: Int){ // constructor 키워드 생략이 가능하다
    val name = "james"
    fun eatingCake(){
        println("케이크 냠냠")
    }
}

class Child (val name: String = "james"){ // default 값도 선언이 가능하다
                                        // default 값이 있으면 생성자에 꼭 파라미터를 넣어주지 않아도 컴파일 에러가 발생하지 않는다
    fun eatingCake(){
        println("케이크 냠냠")
    }
}

class Adult{
    // 생성자가 호출될 때마다 기본적으로 호출되는 블럭
    init {
        println("new adult created")
    }
}

class ConstructorOverloading1 constructor(val name: String){ // 주생성자 선언

    // init은 주 생성자 부 생성자 구분 없이 호출된다
    // init이 먼저 실행되고 그 다음에 부 생성자가 실행된다
    init {
        println("name: ${name}")
    }

    //부 생성자 선언
    constructor(name: String, age: Int): this(name){ // 주 생성자의 위임을 받아야 하기 때문에 주 생성자에 만들어진 파라미터도 꼭 있어야 한다
        println("name: ${name}, age: ${age}")
    }
}

class ConstructorOverloading2 (){ // 주생성자 선언

    // init은 주 생성자 부 생성자 구분 없이 호출된다
    // init이 먼저 실행되고 그 다음에 부 생성자가 실행된다
    init {
        println("new ConstructorOverloading2")
    }

    //부 생성자 선언
    constructor(name: String): this(){
        println("name: ${name}")
    }

    constructor(name: String, age: Int): this(){
        println("name: ${name}, age: ${age}")
    }
}


fun main(){

    val human = Human(20); // new 키워드 없이 바로 인스턴스 생성가능
    human.eatingCake();
    println(human.name);
    println(human.age)

    val male = Male(30)
    println(male.age)

    val female = Female(15)
    println(female.age)

    val child = Child();
    println(child.name)

    val adult1 = Adult()
    val adult2 = Adult()

    val constructorOverloading1 = ConstructorOverloading1("number1")
    val constructorOverloading2 = ConstructorOverloading1("number2", 20)

    val constructorOverloading3 = ConstructorOverloading2();
    val constructorOverloading4 = ConstructorOverloading2("james");
    val constructorOverloading5 = ConstructorOverloading2("judy", 20);

}
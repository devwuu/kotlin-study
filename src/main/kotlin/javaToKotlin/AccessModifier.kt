package javaToKotlin

// 접근 제어자
//  코틀린에서는 패키지를 접근 제어자에 사용하지 않음
// public (모두 접근 가능) --> public (모두 접근 가능)
// protected ( 같은 패키지, 자식) --> protected ( 자기 자신, 자식)
// default ( 같은 패키지 ) --> internal ( 같은 모듈 == 한 번에 컴파일 되는 Kotlin 코드 == gradle source set == idea module == maven project)
// private ( 자기 자신) --> private (자기 자신)

// 기본 접근 제어자는 public ( java는 default)

// 코틀린은 한 파일에 변수, 함수, 클래스 등 여러개를 동시에 정의할 수 있다
// protected 는 class 를 기준으로 하기 때문에 파일 최상단에 사용할 수 없다
// protected를 사용할 때는 자식도 사용할 수 있게하려면 open을 붙여줘야 한다는 걸 잊지 말자
// private는 최상단에 사용할 수 있다. 이때 자기 자신은 파일을 기준으로 함
// 생성자에 접근 지시어를 붙이려면 constructor 키워드를 사용해야 한다

class Males1 private constructor()
//class Males2 private() == > 컴파일 에러

class Apples(
    protected val count: Int, // getter, setter에 모두 protected 접근 제어자 적용
    val freshness: String,
    price: Int
){

    // custom getter, setter와 동일한 구조
    var price = price
        private set // setter만 private 설정

}


// 자바와 코틀린을 함께 사용할 때 주의 사항
// 코틀린의 internal은 컴파일 시 자바에선 public이기 되기 때문에
// java 모듈에서는 internal 키워드가 붙어 있어도 접근이 가능하다
// java 모둘에서는 protected 키워드가 붙어있는 같은 패키지의 코틀린 코드에 접근할 수 있다
// (java가 생각하는 protected와 코틀린이 생각하는 protected가 다르기 때문에 주의한다)

fun main() {
    // 유틸성 함수를 바로 가져다가 사용할 수 있다
    isDirectoryPath("/");
}
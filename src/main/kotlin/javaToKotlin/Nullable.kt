package javaToKotlin

import java.lang.IllegalArgumentException
import javaToKotlin.javas.Person

fun main(){
    val person = Person(null, null)
//    isStartWithA5(person.name);
    // @Nullable 어노테이션을 이해하고 nullable한 데이터로 생각해서
    // non-null 타입에 nullable한 값이 들어오는 것으로 이해한다
    // 그래서 compile에러가 발생한다.

    isStartWithA5(person.grade)
    // 하지만 만약 null과 관련된 어노테이션이 없다면 해당 타입이
    // nullable 인지 non-null 인지 알지 못하기 때문에
    // 런타임에 npe 가 일어날 수 있다.

    // 이런 걸 플랫폼 타입이라고 한다

    // 따라서 자바 라이브러리를 가져다가 사용할 때는 wrapping을 한 번 해주거나
    // 아니면 null이 될 수 있는지 아닌지를 확인하고 사용한다
}

fun isStartWithA1(str: String?) : Boolean {
    // ?: (앨비스 연산자) 앞 연산의 결과가 null 이면 뒤의 결과를 사용함 ( exception 일으키는 것도 가능)
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("str should not null")
}

fun isStartWithA2(str: String?) : Boolean? { // return 타입을 작성해줄 때도 반드시 null이 가능한지 아닌지를 명시해줘야 한다
                                            // nullable 타입은 완전히 다른 타입으로 간주된다고 생각하면 됨
    // str.startsWith("A") //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    // null일 수 있는 변수에서 바로 함수 호출 할 수 없다

    // ?.를 이용해서 safe call
    // null일 경우 메서드를 실행하지 않고 null을 반환
    return str?.startsWith("A")
}

fun isStartWithA3(str: String?) : Boolean {

    // ?: (앨비스 연산자) 앞 연산의 결과가 null 이면 뒤의 결과를 사용함
    return str?.startsWith("A")
        ?: false
}

fun add(a: Int?): Int {
     a ?: return 0 // 이런 식으로 early return에도 사용할 수 있다
    return a.plus(2) // 위에서 null일 경우를 걸러내서 바로 연산 할 수 있음
}

fun isStartWithA4(str: String?) : Boolean {
    return str!!.startsWith("A")
    // !! 을 이용해서 null이 아님을 보증
    // 근데 잘못하면 NPE가 날 수 있음. 반드시 null이 아닐 때만 사용한다
}

fun isStartWithA5(str: String) : Boolean {
    return str.startsWith("A")
}

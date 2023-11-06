fun main(){
    nullCheck();
    nullCheck2("hello")
}

// Nullable VS NonNull

fun nullCheck(){
    // NPE : Null Point Exception

    // String은 not null type이라 null 할당이 안된다
    // var name: String = null;
    var name1: String? = null;
    // ? 를 붙이면 nullable 타입이 돼서 null 할당이 가능하다
    // nullable 타입은 타입을 꼭 선언해준다.
    var name2 = null; // 이것은 가능하지만
    // name2 = "james"; // 재할당이 안된다
    var name3 = "james"; //
    // name3 = null; // 초기화가 된 다음에 null을 할당할 수도 없기 때문에...(String type이라...)

    // 이렇게 해줘야 예상한대로 작동한다.
    var name4: String? = "james";
    name4 = null;

    var name5 : String? = null
    var uppercaseName5 = name5?.uppercase();
    // ?. => null이 아니면 uppercase를 적용하고 null이면 null을 반환합니다
    // js 같다
    // null exception을 컴파일 타임에서 알려주기 때문에 에러를 줄일 수 있다.
    println(uppercaseName5)

    // ?: 앨비스 (프레슬리) 연산자 ㅎㅎ
    var name6: String? = null
    var uppercaseName6 = name6?: "Noname";
    // null일 경우 지정해준 default 값을 반환한다.
    println(uppercaseName6)

}

fun nullCheck2(name: String?) {
    println(name ?: "name is null")
}
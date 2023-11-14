package javaToKotlin

fun main() {

    // arrays
    var arr1 = arrayOf(100, 200, 300)
    for (i in arr1.indices) {
        println("${i} : ${arr1[i]}")
    }
    println("------")
    for ((i, v) in arr1.withIndex()){
        println("${i} : ${v}")
    }
    println("------")

    // 배열에 요소 추가하기
    arr1 = arr1.plus(400)
    println(arr1.contentToString())
    println("------")

    arr1 += 500
    println(arr1.contentToString())


    // list, map, set
    // 코틀린은 가변(mutable) 콜렉션(기본)과 불변 (immutable) 콜렉션이 있다
    // 가변 컬렉션은 element를 추가하거나 삭제할 수 있다
    // 불변 컬렉션은 element를 추가하거나 삭제할 수 없다
    // 불변 컬렉션 이더라도 element의 referenced 객체 값은 바뀔 수 있다 ( refereneced 객체의 주소값이 바뀌는 게 아니기 때문)


    // list
    val list1 = listOf(100, 200, 300)
    val emptyList = emptyList<Int>() // 비어있는 리스트를 만들 수도 있다. 이때는 제네릭 타입을 써줘야 함
    // 타입이 추론 가능하면 emptyList더라도 타입 생략이 가능하다
    printNumbers(emptyList())

    // 리스트와 값
    println(list1[0])
    println(list1.get(0))
    println("------")
    for (e in list1){
        println("${e}")
    }
    println("------")
    for ((i, e) in list1.withIndex()){
        println("${i} : ${e}")
    }

    println("------")
    // 가변리스트
    val list2 = mutableListOf(300, 400, 500) // array list
    list2 += 600
    println(list2.toString()) // 가변 리스트의 경우 array와 다르게 리스트에 값이 바로 추가된다

    // 되도록이면 불변 리스트를 먼저 만들어서 사용한 다음
    // 필요하다면 그때 가변 리스트로 변경하자


    // set
    // 집합. 중복되는 값을 가질 수 없고 순서가 없다
    val set1 = setOf(100, 200, 300)
    println("------")
    for (i in set1){
        println(i)
    }
    println("------")
    val set2 = mutableSetOf(100, 200, 300) // linked hash set
    set2 += 500
    println(set2.toString())

    println("------")
    // map
    // key - value로 이루어진 자료구조
    val map1 = mutableMapOf<Int, String>()
    map1[1] = "MON" // key - value를 이렇게 새로 추가해줄 수 있음
    map1[2] = "TUE"
    map1.put(3, "WED")
    println(map1.toString())

    println("------")
    val map2 = mapOf(1 to "MON", 2 to "TUE") // 이렇게 중위 호출을 이용해 값을 초기화 할 수 있다
    println(map2.toString())
    println("------")

    for (key in map2.keys){
        println("${key} : ${map2[key]}")
    }
    println("------")
    for ((key, element) in map2.entries){
        println("${key} : ${element}")
    }

    // 리스트와 null 가능성
    // List<Int?> : list의 요소는 Null이 가능하지만 list는 null이 아니다
    // List<Int>? : list의 요소는 null이 아니지만 list는 null이 될 수 있다
    // List<Int?>? : list의 요소와 list 모두 null이 될 수 있다

    // 자바와 함께 사용할 때 주의할 점
    // 1. 자바는 nullable 타입과 non-null 타입을 구분하지 않음 -> java가 null을 넣을 가능성
    // 2. 자바는 가변 컬렉션과 불변 컬렉션을 구분하지 않을 수 있음 -> java가 컬렉션을 변경할 가능성
    // 따라서 방어로직을 사용하거나 .unmodifiableList를 사용하거나 List.of()등을 사용한다
    // 즉, 플랫폼 타입에 유의한다
    // 자바 코드를 가져오는 지점을 적절히 wrapping 해서 일괄적으로 잘 처리될 수 있게 한다

}

fun printNumbers(list: List<Int>){
}
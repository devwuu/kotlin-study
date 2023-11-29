package javaToKotlin

fun main() {

    val fruits = mutableListOf<Fruit>(
        Fruit(1, "사과", 1_000, 2_000),
        Fruit(2, "사과", 2_000, 2_000),
        Fruit(3, "사과", 1_000, 2_000),
        Fruit(4, "배", 3_000, 3_000),
        Fruit(5, "배", 1_000, 6_000),
        Fruit(6, "참외", 5_000, 6_000)
    )

    fruits.filter { it.name == "사과" }
    fruits.filterIndexed { index, fruit ->
        println("${index} : ${fruit.name}")
        fruit.currentPrice == (2_000).toLong()
    }

    // chaining으로  사용하기
    fruits.filter { it.name == "사과" }
        .map { it.currentPrice }

    // 모든 과일이 사과일 경우 true
    fruits.all { it.name == "사과" }

    // 모든 과일이 사과가 아닐 경우 true
    fruits.none { it.name == "사과" }

    // 어떤 하나가 사과일 경우 true
    fruits.any { it.name == "사과" }

    // == size
    // 컬렉션의 요소 갯수 세기
    fruits.count()

    // 오름차순 정렬
    fruits.sortBy { it.id }
    // 내림차순 정렬
    fruits.sortByDescending { it.currentPrice }

    // 중복 제거
    fruits.distinctBy { it.name }
        .map { it.name }

    // 첫번째 요소를 가져온다. 만약 대상 리스트가 비어있다면 null을 반환한다
    fruits.firstOrNull()
    // 첫번째 요소를 가져온다. 만약 대상 리스트가 null이라면 null exception 이 발생하게 된다
    fruits.first()

    // 마지막 요소를 가져온다
    fruits.last()
    fruits.lastOrNull()

    // (과일 이름, 과일 리스트)로 되어있는 map이 필요하다면
    fruits.groupBy { fruit -> fruit.name}

    // (과일 아이디, 과일)로 되어있는 map이 필요하다면
    fruits.associateBy { fruit -> fruit.id }

    // 과일 리스트가 아니라 다른 것을 대상으로 map을 만들고 싶다면
    // (과일 이름, 출고가 리스트)로 이루어진 map
    fruits.groupBy({ fruit -> fruit.name }, {fruit -> fruit.currentPrice })
    // 과일 리스트가 아니라 출고가 단일 인스턴스를 가진 Map을 만들고 싶다면?
    fruits.associateBy ({fruit -> fruit.id }, {fruit -> fruit.currentPrice })

    // 리스트가 아니라 map 같은 다른 collection을 대상으로도 상기와 같은 메서드를 사용할 수 있습니다


    // 중첩 리스트
    val fruitsList = listOf(
        listOf(
            Fruit(1, "사과", 1_000, 2_000),
            Fruit(2, "사과", 2_000, 2_000),
            Fruit(3, "사과", 1_000, 2_000)
        ),
        listOf(
            Fruit(4, "배", 3_000, 3_000),
            Fruit(5, "배", 1_000, 6_000)
        ),
        listOf(
            Fruit(6, "참외", 5_000, 6_000)
        )
    )

    // faltmap을 사용하면 중첩 리스트를 단일 리스트로 만들어서 접근할 수 있다
    fruitsList.flatMap { fruits: List<Fruit> ->
        fruits.filter { fruit -> fruit.currentPrice == fruit.factoryPrice }
    }
    // 이렇게 리팩토링도 할 수 있음
    fruitsList.flatMap { fruits: List<Fruit> -> fruits.samePriceFilter1() }
    fruitsList.flatMap { fruits: List<Fruit> -> fruits.samePriceFilter2 }

    // 단일 리스트로 반환해줍니다
    val flatten = fruitsList.flatten()

}


// 확장 함수
fun List<Fruit>.samePriceFilter1() : List<Fruit>{
    return this.filter { fruit -> fruit.currentPrice == fruit.factoryPrice }
}

// 확장 프로퍼티
val List<Fruit>.samePriceFilter2 : List<Fruit>
    get() = this.filter(Fruit::isSamePrice)


fun filterFruit (fruits :List<Fruits>, filter: (Fruits) -> Boolean): List<Fruits> {

//    val list = mutableListOf<Fruits>()
//    for ( fruit in fruits){
//        if(filter(fruit)) list.add(fruit)
//    }
//    return list;

    // 코틀린에서는 함수가 1급 객체이기 때문에 이렇게 바로 파라미터로 넘겨줄 수 있다
   return fruits.filter(filter)
}


data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long
) {
    val isSamePrice: Boolean
        get() = currentPrice == factoryPrice
}
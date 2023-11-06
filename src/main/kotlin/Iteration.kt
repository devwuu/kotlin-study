fun main(){

    // 1. for
    val list1 = arrayListOf("mina", "james", "jenny")
    for(name: String in list1){
        println("my name is ${name}")
    }
    // 타입 생략이 가능합니다
    for(name in list1){
        println("my name is ${name}")
    }

    // 인덱스를 가지고 for문 사용하기
    for(idx in list1.indices){
        println("index ${idx} name is... ${ list1.get(idx) }")
    }
    for(idx in 0 until list1.size){
        println("index ${idx} name is... ${ list1.get(idx) }")
    }
    for((idx, name) in list1.withIndex()){
        println("${idx} name is ${name}")
    }

    // 범위를 지정하기
    var sum = 0;
    for(i in 1..10){ // 1부터 10까지 오름차순
        sum += i;
    }
    println(sum)

    sum = 0;
    for(i in 10 downTo 1){ // 10부터 1까지 내림차순
        sum += i;
    }
    println(sum)

    sum = 0;
    for(i in 1 until 10){ // 1부터 9까지 오름차순 (until은 10을 포함하지 않음)
        sum += i;
    }
    println(sum)

    sum = 0;
    for(i in 1 ..< 10){ // 1부터 9까지 오름차순 ( 10을 포함하지 않음)
        sum += i;
    }
    println(sum)


    // 등차 적용하기
    sum = 0;
    for(i in 1..10 step 2){
        sum += i;
    }
    println(sum)



    // 2. while
    var index = 0;
    while(index < 5){
        println("current index: ${index}")
        index++
    }
}

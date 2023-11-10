package joyce

fun main(){
    arrays();
}

fun arrays(){

    //Array
    val array1 = arrayOf(1,2,3);

    //List
    //immutable : 수정불가능
    //mutable : 수정가능
    val list1 = listOf(1,2,3); //immutable

    // 여러가지 타입을 혼합해서 사용할 수도 있다
    val array2 = arrayOf(1, "hi", 1.2f);
    val list2 = listOf(1, "hi", 1.2f);

    array1[0] = 20; // 가능
//    list1[1] = 20; // 불가능 (readonly)
    println(array1[0])
    println(list1.get(1))
    println(list1[1])

    // mutable
    val arrayList1 = arrayListOf(1,2,3)
    arrayList1.add(10);
    val arrayList2 = ArrayList<Int>();
    arrayList2.add(20);
    // arrayList2 = arrayList1; val는 재할당 불가.
    // 요소 추가는 변수가 가리키는 주소값이 변하는 것이 아니기때문에 수정이 가능한 것.



}
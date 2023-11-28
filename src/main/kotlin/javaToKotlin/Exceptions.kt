package javaToKotlin

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    readFile()
    readFile("/Users/dev/Desktop/workspace/kotlin-basic/a.txt")
}

fun parseIntOrThrow(number: String): Int{
    try {
       return number.toInt()
    }catch (e: NumberFormatException){
        throw IllegalArgumentException("${number} 는 숫자가 아닙니다")
    }
}

fun parseIntOrNull(number: String): Int?{

    // try-catch 역시 expression 이기 때문에 바로 return 해줄 수 있다
    return try {
        number.toInt()
    }catch (e: NumberFormatException){
        null
    }
}

fun readFile(){
    val currentFile = File("")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()

    // 코틀린에서는 unchecked exception과 checked exception을 구분하지 않는다
    // 모두 unchecked exception이다
}

fun readFile(path: String){
    // try-resource 와 동일한 기능 ( use: inline 확장 함수 )
    // resource 사용이 끝나면 자동으로 close 해준다
    // Executes the given block function on this resource
    // and then closes it down correctly
    // whether an exception is thrown or not
    BufferedReader(FileReader(path)).use {
        println(it.readLine())
    }
    // {}는 람다식
    // 사실 () 안에 들어갔어야 하는 게 맞지만 마지막 파라미터라서 밖에 나왔다
    // 그리고 BufferedReader가 가지고있는 use 라는 확장 함수이다
}
package javaToKotlin

// 이런식으로 바로 util성 함수를 정의해주면 편하다
fun isDirectoryPath(path: String): Boolean{
    return path.endsWith("/")
}
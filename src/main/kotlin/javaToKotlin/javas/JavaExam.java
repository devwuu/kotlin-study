package javaToKotlin.javas;

import javaToKotlin.EtcFuntionsKt;
import javaToKotlin.Teacher;

public class JavaExam {

    public static void main(String[] args) {
        int number1 = 1;
        long number2 = 2;
        number2 = number1; // 암묵적 타입 캐스팅


        Teacher.Factory.log();
        Teacher.log(); // 컴패니언 오브젝트 이름을 생략하고 접근하고 싶다면 코틀린 쪽에 @JvmStatic 어노테이션을 붙여줘야한다

        // java 에서도 코틀린의 확장 함수를 static method처럼 가져다가 사용할 수 있음
        System.out.println(EtcFuntionsKt.lastChar("ABC"));


    }

}

package javaToKotlin.javas;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JavaMoney implements Comparable<JavaMoney>{

    private Long myMoney;

    public JavaMoney(Long myMoney){
        this.myMoney = myMoney;
    }

    @Override
    public int compareTo(@NotNull JavaMoney o) {
        System.out.println("comparedTo...");
        return Long.compare(myMoney, o.myMoney);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaMoney javaMoney = (JavaMoney) o;
        return Objects.equals(myMoney, javaMoney.myMoney);
    }

}

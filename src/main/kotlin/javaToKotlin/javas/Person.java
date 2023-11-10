package javaToKotlin.javas;

import org.jetbrains.annotations.Nullable;

public class Person {
    private String name;
    private String grade;

    public Person(String name, String grade){
        this.name = name;
        this.grade = grade;
    }
    @Nullable
    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

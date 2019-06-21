package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.stream;

import java.util.function.Predicate;

public class Student {
    int no;
    String name;
    String sex;
    float height;

    public Student(int no, String name, String sex, float height) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }
}
class Te implements Predicate{

    @Override
    public boolean test(Object o) {
        return false;
    }
}

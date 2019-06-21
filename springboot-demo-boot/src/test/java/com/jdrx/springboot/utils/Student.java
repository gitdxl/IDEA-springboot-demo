package com.jdrx.springboot.utils;

/**
 * Created by dengxuelong on 2017/12/11.
 */
public class Student {
    Integer id;
    String name;
    String sex;
    String className;

    public Student(Integer id, String name, String sex, String className) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

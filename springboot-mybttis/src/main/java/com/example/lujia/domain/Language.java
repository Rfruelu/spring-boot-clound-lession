package com.example.lujia.domain;

/**
 * Created by LuTshoes on 2017/7/18 0018.
 * lutshoes@163.com
 */
public class Language {
    private Long id;
    private String name;
    private Integer age;

    public Language() {
    }

    public Language(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

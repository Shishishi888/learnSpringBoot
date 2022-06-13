package com.tjulab.helloworld.bean;

public class User {
    private String name;
    private Integer age;

    private Pet pet;

    public User(){

    }

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Pet getPet() {
        return pet;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}

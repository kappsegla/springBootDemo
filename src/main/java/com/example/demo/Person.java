package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    int id;
    String name;
    @JsonIgnore
    int age;
    @JsonProperty("town")
    String homeTown;

    public Person(){
        
    }

    public Person(int id, String name, int age, String homeTown) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", homeTown=" + homeTown + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
    
}

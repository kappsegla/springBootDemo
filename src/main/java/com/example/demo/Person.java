package com.example.demo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;
    
    String name;
    @JsonIgnore
    @Transient
    int age;
    @JsonProperty("town")
    @Column(name="hometown", length = 120)
    String homeTown;
    String country;
    @ManyToMany
    Set<Dog> dogs;


    public Person(){
        
    }

    public Person(String name, int age, String homeTown) {
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
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
        return "Person [ID=" + ID + ", name=" + name + ", age=" + age + ", homeTown=" + homeTown + "]";
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

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }
    
}

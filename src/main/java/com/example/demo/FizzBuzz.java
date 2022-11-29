package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Person;

public class FizzBuzz {

    public static String fizzBuzz(String value) {
        if( value == null || value.isEmpty())
            return "0";
        int tal  = Integer.parseInt(value);
        if( tal == 0)
            return value;
        if( tal % 3 == 0 && tal % 5 == 0)
            return "FizzBuzz";
        if( tal % 3 == 0 )
            return "Fizz";
        if( tal % 5 == 0)
            return "Buzz";            
        return value;
    }

    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

}

package com.example.demo;

public class FizzBuzz {

    public static String fizzBuzz(String value) {
        int tal  = Integer.parseInt(value);
        if( tal == 0)
            return value;
        if( tal % 3 == 0 )
            return "Fizz";
        if( tal % 5 == 0)
            return "Buzz";            
        return value;
    }

}

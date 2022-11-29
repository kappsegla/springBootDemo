package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class FizzBuzzTests {


    @Test
    void givenValueZeroShouldReturnZero(){
        
        String result = FizzBuzz.fizzBuzz("0");

        assertThat(result).isEqualTo("0");
    }

    @Test
    void givenValueOneShouldReturnOne(){
        
        String result = FizzBuzz.fizzBuzz("1");

        assertThat(result).isEqualTo("1");
    }



}

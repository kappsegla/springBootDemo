package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class FizzBuzzTests {


    @Test
    void givenValueZeroShouldReturnZero(){
        
        String result = FizzBuzz.fizzBuzz("0");

        assertThat(result).isEqualTo("0");
    }

}

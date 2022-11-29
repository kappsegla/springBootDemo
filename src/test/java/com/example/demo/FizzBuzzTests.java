package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.demo.entity.Person;

import static org.assertj.core.api.Assertions.*;

public class FizzBuzzTests {

    @Test
    void givenValueZeroShouldReturnZero() {

        String result = FizzBuzz.fizzBuzz("0");

        assertThat(result).isEqualTo("0");
    }

    @Test
    void givenValueOneShouldReturnOne() {

        String result = FizzBuzz.fizzBuzz("1");

        assertThat(result).isEqualTo("1");
    }

    @Test
    void givenValueThreeShouldReturnFizz() {

        String result = FizzBuzz.fizzBuzz("3");

        assertThat(result).isEqualTo("Fizz");
    }

    @ParameterizedTest(name = "For value {0} should return {1}")
    @CsvSource({
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "15,FizzBuzz",
            ",0",
            "'',0"
    })
    void shouldReturnFizzBuzz(String value, String expectedResult) {
        String result = FizzBuzz.fizzBuzz(value);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnListOfPersons() {
        // Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();
        Person person = new Person();
        person.setId(1L);
        person.setName("Martin");
        
        // Act        
        fizzBuzz.add(person);

        // Assert
        var result = fizzBuzz.getPersons();
        assertThat(result)
                .hasSize(1)
                .contains(person)
                .extracting(t -> t.getId())
                .isNotEqualTo(2L);
                
    }
}

package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AgeServiceTest {


    @Test
    @DisplayName("Given a year before now should return false 🙈")
    void givenAYearBeforeNowShouldReturnFalse(){

        AgeService ageService = new AgeService();

        var result = ageService.isInFuture(1980);
        
        assertFalse(result);
        //assertThat(result).isFalse();
    }

    @Test
    void givenAYearInTheFutureShoudlReturnTrue(){
        AgeService ageService = new AgeService();
        int yearInFuture = LocalDate.now().getYear() + 1;

        var result = ageService.isInFuture(yearInFuture);

        assertTrue(result);
        //assertThat(result).isTrue();
    }

    @Test
    void givenAYearOfBirthAs2000ShouldReturnAge22(){
        //Arrange
        AgeService ageService = new AgeService(2022);
        //Act
        var result = ageService.calculateAge(2000);
        //Assert
        //assertEquals(22, result);
        assertThat(result).isEqualTo(22);
    }
}

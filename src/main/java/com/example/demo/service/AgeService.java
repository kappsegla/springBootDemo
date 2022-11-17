package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class AgeService {
    
    public boolean isInFuture(int yearOfBirth){

        LocalDate date = LocalDate.now();
        return yearOfBirth > date.getYear();
    }

    public int calculateAge(int yearOfBirth){
        return LocalDate.now().getYear() -  yearOfBirth;
    }

}

package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class AgeService {

    private int currentYear;

    public AgeService(int currentYear) {
        this.currentYear = currentYear;
    }

    public AgeService() {
        this.currentYear = LocalDate.now().getYear();
    }

    public boolean isInFuture(int yearOfBirth) {
        LocalDate date = LocalDate.now();
        return yearOfBirth > date.getYear();
    }

    public int calculateAge(int yearOfBirth) {
        return currentYear - yearOfBirth;
    }

}

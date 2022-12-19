package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.validators.ValidationErrorResponse;
import com.example.demo.validators.Violation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
@ResponseBody
public class GlobalControllerAdvice {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(CustomException exception) {
        return String.format("The HTTP Status will be Bad Hairday\n %s\n",exception.getMessage()) ;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(
        ConstraintViolationException e) {
      ValidationErrorResponse error = new ValidationErrorResponse();
      for (ConstraintViolation violation : e.getConstraintViolations()) {
        error.getViolations().add(
          new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
      }
      return error;
    }
  
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ResponseBody
    // ValidationErrorResponse onMethodArgumentNotValidException(
    //     MethodArgumentNotValidException e) {
    //   ValidationErrorResponse error = new ValidationErrorResponse();
    //   for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
    //     error.getViolations().add(
    //       new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
    //   }
    //   return error;
    // }

}
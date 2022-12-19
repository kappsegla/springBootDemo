package com.example.demo.model;

import com.example.demo.validators.IpAddress;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Info {

    Long Id;
    //@NotEmpty(message = "Message can't be empty")
    @Size(
    min = 5,
    max = 14,
    message = "The message '${validatedValue}' must be between {min} and {max} characters long"
    )
    String message;
    @Max(10)
    @Min(value = 1, message = "Invalid value '${validatedValue}' for counter")
    int counter;

    @IpAddress(message = "Invalid ip address. Use format xxx.xxx.xxx.xxx where xxx are 0-255")
    private String ipAddress;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}

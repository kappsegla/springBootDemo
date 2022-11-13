package com.example.demo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Airport {
 
    @EmbeddedId
    private AirportID id;

    public AirportID getId() {
        return id;
    }

    public void setId(AirportID id) {
        this.id = id;
    }
         
     
     
}
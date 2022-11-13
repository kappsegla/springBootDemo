package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface AirportRepo extends CrudRepository<Airport,AirportID> {
    
}

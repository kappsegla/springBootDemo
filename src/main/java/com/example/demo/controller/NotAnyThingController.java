package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Info;

import jakarta.validation.Valid;

@RestController
public class NotAnyThingController {

    @GetMapping("/info")
    public List<Info> getAllInfo() {
        return List.of();
    }

    @PostMapping("/info")
    public ResponseEntity<Info> addInfo(@Valid @RequestBody Info info) {
        info.setId(1L);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(info.getId())
        .toUri();

        return ResponseEntity.created(location).body(info);
    }

    

    

}
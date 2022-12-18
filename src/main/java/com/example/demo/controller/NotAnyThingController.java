package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Info;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class NotAnyThingController {

    @GetMapping("/info")
    public List<Info> getAllInfo() {
        return List.of();
    }

    @PostMapping("/info")
    public ResponseEntity<Info> addInfo(@RequestBody Info info) {
        info.setId(1L);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(info.getId())
        .toUri();

        return ResponseEntity.created(location).body(info);
    }

    

}
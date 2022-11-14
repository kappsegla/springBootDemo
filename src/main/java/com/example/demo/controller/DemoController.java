package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@RestController
public class DemoController {

    PersonRepository personRepository;

    public DemoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getPerson() {
        return List.of();
    }

    @GetMapping("/persons/{id}")
    public Person getOnePerson(@PathVariable int id) {
        return null;
    }

    // @PostMapping("/persons")
    // @ResponseStatus(HttpStatus.CREATED)
    // public Person addPerson(@RequestBody Person person) {
    //     return personRepository.save(person);
    // }
    
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
            
        var p = personRepository.save(person);
        return  ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(p.getId())
            .toUri())
            .build();
    }

}

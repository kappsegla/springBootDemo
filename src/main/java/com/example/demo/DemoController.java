package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/demo")
    public String demo(){
        return "Hello there";
    }

    @GetMapping("/persons")
    public List<Person> getPerson(){
        return List.of(new Person(0,"Martin", 45, "Kalmar"),
        new Person(1,"Kalle", 30, "Lund"));
    }

    @GetMapping("/persons/{id}")
    public Person getOnePerson(@PathVariable int id){
        return new Person(id, "Kalle", 45, "Kalmar");
    }

    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person){
        return person.toString();
    }

  /*   @GetMapping("/sorting")
    public String demoSorting(@RequestParam String order){
        return order;
    }
*/
    @GetMapping("/sorting")
    public Set<Entry<String, String>> demoSorting(@RequestParam Map<String,String> urlParams){
        return urlParams.entrySet();
    }


}

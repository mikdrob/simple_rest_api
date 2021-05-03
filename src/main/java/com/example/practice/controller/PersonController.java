package com.example.practice.controller;
import com.example.practice.exception.GlobalExceptionHandler;
import com.example.practice.model.Person;
import com.example.practice.api.dto.v1.PersonDto;
import com.example.practice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("person")
    public ResponseEntity<List<Person>> getPersonByName(@RequestParam() String search){
        return ResponseEntity.ok(service.getPersonByName(search));
    }

    @GetMapping
    public ResponseEntity<List<Person>> GetPersons() {

        return ResponseEntity.ok(service.GetAll());
    }


    @PostMapping
    public ResponseEntity<Person> PostPerson(@Valid @RequestBody PersonDto person){

        Person entity = new Person();
        entity.setName(person.getName());
        return ResponseEntity.ok(service.Add(entity));
    }

}

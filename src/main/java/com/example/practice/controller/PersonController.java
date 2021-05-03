package com.example.practice.controller;
import com.example.practice.model.Person;
import com.example.practice.api.dto.v1.PersonDto;
import com.example.practice.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getPersonByName")
    @GetMapping("person")
    public ResponseEntity<List<Person>> getPersonByName(@RequestParam() String search){
        return ResponseEntity.ok(service.getPersonByName(search));
    }

    @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getAlL")
    @GetMapping
    public ResponseEntity<List<Person>> GetPersons() {

        return ResponseEntity.ok(service.GetAll());
    }


    @ApiResponse(code = 500, message = "Wrong request. Length should not exceed 30 characters. Try again!")
    @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "postPerson")
    @PostMapping
    public ResponseEntity<Person> PostPerson(@Valid @RequestBody PersonDto person) {
        Person entity = new Person();
        entity.setName(person.getName());
        return ResponseEntity.ok(service.Add(entity));
    }



}

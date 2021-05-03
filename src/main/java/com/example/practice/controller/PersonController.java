package com.example.practice.controller;

import com.example.practice.api.dto.v1.Person;
import com.example.practice.repository.PersonRepository;
import com.example.practice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController extends BaseController<Person> {

    private final PersonService service;

    @Autowired
    public PersonController(PersonRepository repository, PersonService service) {
        super(repository);
        this.service = service;
    }

    @GetMapping("person")
    public ResponseEntity<List<Person>> getPersonByName(@RequestParam() String search){
        return ResponseEntity.ok(service.getPersonByName(search));
    }



}

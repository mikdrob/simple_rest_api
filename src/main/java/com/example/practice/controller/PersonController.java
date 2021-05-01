package com.example.practice.controller;

import com.example.practice.dto.Person;
import com.example.practice.repository.BaseRepositoryBean;
import com.example.practice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/index")
public class PersonController extends BaseController<Person> {

    private final PersonService service;

    @Autowired
    public PersonController(BaseRepositoryBean repository, PersonService service) {
        super(repository);
        this.service = service;
    }

    @GetMapping(path = "person")
    public List<Person> getPersonByName(@RequestParam() String search){
        return service.getPersonByName(search);
    }


}

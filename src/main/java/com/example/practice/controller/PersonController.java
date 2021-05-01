package com.example.practice.controller;

import com.example.practice.dto.Person;
import com.example.practice.repository.BaseRepositoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/index")
public class PersonController extends BaseController<Person> {
    public PersonController(BaseRepositoryBean repository) {
        super(repository);
    }
}

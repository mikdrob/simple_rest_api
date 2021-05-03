package com.example.practice.service;

import com.example.practice.api.dto.v1.Person;
import com.example.practice.repository.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
public class PersonService{
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonByName(String name) {
        return personRepository.getPersonByName(name);
    }




}

package com.example.practice.service;

import com.example.practice.model.Person;
import com.example.practice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService{
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonByName(String name) {
        return personRepository.getPersonByName(name);
    }

    public List<Person> GetAll() {
        return personRepository.findAll();
    }

    public Person Add(Person entity) {
        return personRepository.save(entity);
    }


}

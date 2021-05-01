package com.example.practice.repository;

import com.example.practice.dto.Person;

import java.util.List;

public interface PersonRepositoryCustom {
    List<Person> getPersonByName(String name);

}

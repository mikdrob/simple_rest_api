package com.example.practice.repository;

import com.example.practice.api.dto.v1.Person;

import java.util.List;

public interface PersonRepositoryCustom {
    List<Person> getPersonByName(String name);

}

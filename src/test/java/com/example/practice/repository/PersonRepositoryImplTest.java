package com.example.practice.repository;

import com.example.practice.api.dto.v1.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryImplTest {

    @Autowired
    private PersonRepository repository;

    @Test
    void getPersonByName() {
        // given
        Person person = new Person();
        person.setName("John");
        repository.save(person);

        // when
        List<Person> foundPersons = repository.getPersonByName("J");

        // then
        assertThat(foundPersons).isNotEmpty();
    }
}
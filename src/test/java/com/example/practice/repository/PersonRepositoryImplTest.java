package com.example.practice.repository;

import com.example.practice.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryImplTest {

    @Autowired
    private PersonRepository repository;

    @Test
    void getPersonByName() {
        // given
        Person person = new Person();
        person.setName("John Smith");
        repository.save(person);

        // when
        List<Person> foundPersons = repository.getPersonByName("J");

        // then
        assertThat(foundPersons).isNotEmpty();
    }
}
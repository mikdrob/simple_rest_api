package com.example.practice.service;

import com.example.practice.model.Person;
import com.example.practice.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService testService;

    @BeforeEach
    void setUp(){
        testService = new PersonService(personRepository);
    }


    @Test
    void canGetAll() {
        // when
        testService.GetAll();
        // then
        verify(personRepository).findAll();
    }

    // argument capture test
    @Test
    void canAdd() {
        // given
        Person person = new Person();
        person.setName("John");

        // when
        testService.Add(person);

        // then
        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personRepository).save(personArgumentCaptor.capture());

        // making sure that an entity passed to service is the same the service will use to add a new record
        Person capturedPerson = personArgumentCaptor.getValue();
        assertThat(capturedPerson).isEqualTo(person);
    }
}
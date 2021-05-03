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
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService underTest;

    @BeforeEach
    void setUp(){
        underTest = new PersonService(personRepository);
    }


    @Test
    void canGetAll() {
        // when
        underTest.GetAll();
        // then
        verify(personRepository).findAll();
    }

    @Test
    void canAdd() {
        // given
        Person person = new Person();
        person.setName("John");

        // when
        underTest.Add(person);

        // then
        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personRepository).save(personArgumentCaptor.capture());

        Person capturedPerson = personArgumentCaptor.getValue();
        assertThat(capturedPerson).isEqualTo(person);
    }
}
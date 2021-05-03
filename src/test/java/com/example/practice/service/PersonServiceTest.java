package com.example.practice.service;

import com.example.practice.api.dto.v1.Person;
import com.example.practice.repository.PersonRepository;
import com.example.practice.repository.base.BaseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private BaseRepository<Person> baseRepository;
    private BaseService<Person> underTest;

    @BeforeEach
    void setUp(){
        underTest = new BaseService<>(baseRepository);
    }


    @Test
    void canGetAll() {
        // when
        underTest.GetAll();
        // then
        verify(baseRepository).findAll();
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
        verify(baseRepository).save(personArgumentCaptor.capture());

        Person capturedPerson = personArgumentCaptor.getValue();
        assertThat(capturedPerson).isEqualTo(person);
    }
}
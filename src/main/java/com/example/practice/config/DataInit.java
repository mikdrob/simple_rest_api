package com.example.practice.config;

import com.example.practice.model.Person;
import com.example.practice.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInit {
    private final String name = "Siim Toomingas";
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        Person person = new Person();
        person.setName(name.toLowerCase());
        return args -> {
            repository.saveAll(List.of(person));
        };
    }
}

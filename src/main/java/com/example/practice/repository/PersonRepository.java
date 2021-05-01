package com.example.practice.repository;

import com.example.practice.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT s FROM Person s WHERE s.name = ?1")
    Optional<Person> findPersonByName(String fullName);

    @Query("SELECT s FROM Person s WHERE s.name LIKE %?1%")
    List<Person> getPersonByName(String fullName);
}
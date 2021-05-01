package com.example.practice.repository;

import com.example.practice.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

}
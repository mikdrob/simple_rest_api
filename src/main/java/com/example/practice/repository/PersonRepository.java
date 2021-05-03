package com.example.practice.repository;

import com.example.practice.api.dto.v1.Person;
import com.example.practice.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom, BaseRepository<Person>  {

}
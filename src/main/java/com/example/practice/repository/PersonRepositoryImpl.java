package com.example.practice.repository;

import com.example.practice.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private final EntityManager em;

    public PersonRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Person> getPersonByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);

        Root<Person> person = cq.from(Person.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.like(person.get("name"), "%" + name + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }
}

package com.example.practice.repository;

import com.example.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    // custom method to get rid of sql with the help of jpa criteria

    @Override
    public List<Person> getPersonByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);

        Root<Person> person = query.from(Person.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(builder.like(person.get("name"), "%" + name.toLowerCase() + "%"));
        }
        query.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(query).getResultList();
    }
}

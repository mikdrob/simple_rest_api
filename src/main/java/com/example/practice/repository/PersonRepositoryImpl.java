package com.example.practice.repository;

import com.example.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

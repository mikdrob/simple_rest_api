package com.example.practice.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class NameValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testNameSuccess() {
        // I'd name the test to something like
        // invalidEmailShouldFailValidation()

        Person person = new Person();
        person.setName("Jack");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertFalse(violations.isEmpty());
    }

}

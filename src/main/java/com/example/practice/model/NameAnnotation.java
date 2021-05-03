package com.example.practice.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameAnnotation {

    String message() default "Invalid name format. Try: Firstname Lastname. Each 30 characters longest";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
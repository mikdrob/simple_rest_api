package com.example.practice.model;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameAnnotation, String> {

    // Name validation. Checks if the format is correct. firstname (space) lastname.
    private static final String NAME_REGEX = "(^[a-zA-Z]{1,30}+\\s[A-Za-z]{1,30}+$)";

    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    @Override
    public void initialize(NameAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        Matcher matcher = NAME_PATTERN.matcher(name);

        return matcher.matches();

    }
}
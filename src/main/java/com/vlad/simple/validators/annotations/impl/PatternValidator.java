package com.vlad.simple.validators.annotations.impl;

import com.vlad.simple.validators.annotations.PatternValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatternValidator implements ConstraintValidator<PatternValidation, String> {
    private String regexp;
    private int min;
    private int max;

    @Override
    public void initialize(PatternValidation constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches(regexp) && s.length() >= min && s.length() <= max;
    }
}

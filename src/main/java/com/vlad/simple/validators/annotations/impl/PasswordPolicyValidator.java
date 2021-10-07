package com.vlad.simple.validators.annotations.impl;

import com.vlad.simple.validators.annotations.PasswordPolicy;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordPolicyValidator implements ConstraintValidator<PasswordPolicy, String> {
    private String message;
    private int min;
    private int max;
    List<String> valueList;

    @Override
    public void initialize(PasswordPolicy passwordPolicy) {
        this.min = passwordPolicy.min();
        this.max = passwordPolicy.max();
        this.message = passwordPolicy.message();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator passwordValidator = new PasswordValidator(Arrays.asList(
                new LengthRule(min,max),
                new UppercaseCharacterRule(1),
                new DigitCharacterRule(1)));
        RuleResult result = passwordValidator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return false;
    }
}

package com.vlad.simple.validators.annotations;

import com.vlad.simple.validators.annotations.impl.PatternValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PatternValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternValidation {
    String regexp();
    int min() default 0;
    int max() default 2147483647;
    String message() default "Pattern Missmatch";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

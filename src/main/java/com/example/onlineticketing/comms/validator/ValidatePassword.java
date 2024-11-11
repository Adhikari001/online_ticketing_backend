package com.example.onlineticketing.comms.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface ValidatePassword {
    String message() default "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character. Special characters are !@#$%^&*()_+-=[]{}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.cooksys.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueFirstAndLastValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueFirstAndLast {
	String message() default "Must have unique First and Last name combination!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.spring.hibernate.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailConstraintValidation.class)
@Target({ElementType.FIELD , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidation 
{
	public String value() default "@";
	public String message() default "Must contain @ ";	
	public Class<?>[] groups()default{};
	public Class<? extends Payload>[] payload()default{};
}

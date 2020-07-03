package com.spring.hibernate.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidation implements ConstraintValidator<EmailValidation, String> {

	public String EmailSuffix;
	
	@Override
	public void initialize(EmailValidation constraintAnnotation) {
		// TODO Auto-generated method stub
		EmailSuffix = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String thecode, ConstraintValidatorContext arg1) 
	{
		boolean result;
		if(thecode!=null)
		{
			result = thecode.contains(EmailSuffix);
		}else {
			result=true;
		}	
		return result;
	}
}

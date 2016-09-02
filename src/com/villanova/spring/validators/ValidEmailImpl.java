package com.villanova.spring.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String>{

	
	public ValidEmailImpl() {
		super();
		System.out.println("I am being create again");
	}

	@Override
	public String toString() {
		return "ValidEmailImpl [email=" + email + ", min=" + min + ", max="
				+ max + "]";
	}

	String email;
	private int min, max;
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		min=constraintAnnotation.min();
		max=constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		this.email=value;
		if(value.length() > max)
			return false;
		if(value.length()< min)
			return false;
		if(!EmailValidator.getInstance(true).isValid(value))
			return false;
		
		return true;
	}

}

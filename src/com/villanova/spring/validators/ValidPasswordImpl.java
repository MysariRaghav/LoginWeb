package com.villanova.spring.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.villanova.server.Server;

@Component
public class ValidPasswordImpl implements ConstraintValidator<ValidPassword, String>{
	
	/*@Autowired
	private ValidEmailImpl emailImpl;*/
	@Autowired
	private Server server;
	private int min, max;
	@Override
	public void initialize(ValidPassword constraintAnnotation) {
		// TODO Auto-generated method stub
		min=constraintAnnotation.min();
		max=constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value.length() > max)
			return false;
		if(value.length()< min)
			return false;
		/*System.out.println(emailImpl);
		if(!server.getPasswordByEmail("rmysari1@villanova.edu").getPassword().equals(value))
			return false;*/
		
		return true;
	}

}

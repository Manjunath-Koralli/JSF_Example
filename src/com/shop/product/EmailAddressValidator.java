package com.shop.product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailAddressValidator implements ConstraintValidator<ValidEmailAddress, String>{

	@Override
	public void initialize(ValidEmailAddress arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return value == null || value.equals("") || value.contains("@");
	}

}

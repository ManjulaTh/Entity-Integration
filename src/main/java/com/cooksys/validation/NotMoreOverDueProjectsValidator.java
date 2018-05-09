package com.cooksys.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotMoreOverDueProjectsValidator implements ConstraintValidator<NotMoreThanTwentyYears, Date>{
	
	private Date date;
	private Date date2;
	
	@Override
	public void initialize(NotMoreThanTwentyYears constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		date = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 365 * 20);
		date2 = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365 * 10);
		
		return value.after(date) && value.before(date2);
	}

}

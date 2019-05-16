package com.shop.springboot.demo.motoshopdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	
	private String firstField;
	private String secondField;
	private String message;
	
	
	
	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
	
		boolean valid = true;
		
		try {
			
			final Object firstObject = new BeanWrapperImpl(value).getPropertyValue(firstField);
			final Object secondObject = new BeanWrapperImpl(value).getPropertyValue(secondField);
			
			valid = firstObject == null && secondObject == null || firstObject != null && firstObject.equals(secondObject);
			
		} catch (final Exception e) {
			
		}
		
		if (!valid) {
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode(firstField)
					.addConstraintViolation()
					.disableDefaultConstraintViolation();
		}
		
		return valid;
	
	}
	
}

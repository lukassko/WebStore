package com.app.store.utility;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.store.model.Client;

public class EmailValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Client.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		Client client = (Client) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "", "Email is empty");
		if (!client.getEmail().contains("@"))
			error.rejectValue("email", "", "Email is not valid.");
	}

}

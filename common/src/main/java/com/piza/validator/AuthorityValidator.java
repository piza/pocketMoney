package com.piza.validator;

import com.piza.model.Authority;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class AuthorityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Authority.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

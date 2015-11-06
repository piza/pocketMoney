package com.piza.validator;

import com.piza.model.UserLog;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class UserLogValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserLog.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

package com.piza.validator;

import com.piza.model.WeixinAccount;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class WeixinAccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return WeixinAccount.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

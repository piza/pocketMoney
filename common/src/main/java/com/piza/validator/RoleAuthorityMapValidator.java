package com.piza.validator;

import com.piza.model.RoleAuthorityMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class RoleAuthorityMapValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RoleAuthorityMap.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

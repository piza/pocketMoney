package com.piza.validator;

import com.piza.model.UserInfoRoleMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class UserInfoRoleMapValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfoRoleMap.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

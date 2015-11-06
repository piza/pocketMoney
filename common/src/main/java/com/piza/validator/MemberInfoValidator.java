package com.piza.validator;

import com.piza.model.MemberInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class MemberInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MemberInfo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

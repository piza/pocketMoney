package com.piza.validator;

import com.piza.model.FavoriteSite;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class FavoriteSiteValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return FavoriteSite.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

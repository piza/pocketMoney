package com.piza.validator;

import com.piza.model.DailyPicture;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class DailyPictureValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return DailyPicture.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

package com.piza.validator;

import com.piza.model.DailyNote;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class DailyNoteValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return DailyNote.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

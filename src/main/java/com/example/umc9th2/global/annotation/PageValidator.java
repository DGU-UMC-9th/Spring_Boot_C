package com.example.umc9th2.global.annotation;

import com.example.umc9th2.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th2.global.apiPayload.exception.GeneralException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//tnwjdwnd

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public void initialize(ValidPage constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null) {
            throw new GeneralException(GeneralErrorCode.INVALID_PAGE);
        }
        if (page <= 0) {
            throw new GeneralException(GeneralErrorCode.INVALID_PAGE);
        }
        return true;
    }
}
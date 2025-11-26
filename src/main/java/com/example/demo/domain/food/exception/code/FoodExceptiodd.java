package com.example.demo.domain.food.exception.code;

import com.example.demo.global.apiPayload.code.BaseErrorCode;
import com.example.demo.global.apiPayload.exception.GeneralException;

public class FoodExceptiodd extends GeneralException {
    public FoodExceptiodd(BaseErrorCode code) {
        super(code);
    }
}

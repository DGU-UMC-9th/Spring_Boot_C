package com.example.demo.domain.food.exception.code;

import com.example.demo.global.apiPayload.code.BaseErrorCode;
import com.example.demo.global.apiPayload.code.GeneralErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FoodErrorCode implements BaseErrorCode {
    Food_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD404","이거는 푸드 테스트");
    private final HttpStatus status;
    private final String code;
    private final String message;
}

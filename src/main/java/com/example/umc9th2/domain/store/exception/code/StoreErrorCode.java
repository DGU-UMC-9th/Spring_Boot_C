package com.example.umc9th2.domain.store.exception.code;

import com.example.umc9th2.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "STORE404_1",
            "가게를 찾을 수 없습니다."),
    ;

    private final org.springframework.http.HttpStatus status;
    private final String code;
    private final String message;
}


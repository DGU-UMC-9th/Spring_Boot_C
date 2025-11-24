package com.example.demo.domain.review.exception.code;

import com.example.demo.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    Review_EXCEPTION(HttpStatus.BAD_REQUEST, "REVIEW400","이거는 리뷰테스트"),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    // 200 OK: 가장 일반적인 성공
    OK(HttpStatus.OK, "COMMON200_1", "성공입니다."),

    // 201 Created: 리소스가 성공적으로 생성됨
    CREATED(HttpStatus.CREATED, "COMMON201_1", "정상적으로 생성되었습니다."),

    // 202 Accepted: 요청이 접수되었으나 처리가 완료되지 않음
    ACCEPTED(HttpStatus.ACCEPTED, "COMMON202_1", "요청이 정상적으로 접수되었습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}

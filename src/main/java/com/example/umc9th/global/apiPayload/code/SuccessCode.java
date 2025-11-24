package com.example.umc9th.global.apiPayload.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements BaseSuccessCode {

    _OK(HttpStatus.OK, "COMMON_200", "요청이 성공적으로 처리되었습니다."),
    _CREATED(HttpStatus.CREATED, "COMMON_201", "요청이 성공적으로 처리되었으며, 리소스가 생성되었습니다."),
    READ_SUCCESS(HttpStatus.OK, "COMMON_200", "데이터 조회에 성공했습니다."),
    UPDATE_SUCCESS(HttpStatus.OK, "COMMON_200", "데이터 수정에 성공했습니다."),
    DELETE_SUCCESS(HttpStatus.OK, "COMMON_200", "데이터 삭제에 성공했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
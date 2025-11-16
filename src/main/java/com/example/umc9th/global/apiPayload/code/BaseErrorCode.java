package com.example.umc9th.global.apiPayload.code;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    HttpStatus getStatus(); // HTTP 상태 코드를 반환
    String getCode(); // 서비스 내부에서 직접 정의하는 '커스텀 에러 코드'를 반환
    String getMessage(); // 사용자 또는 개발자에게 보여줄 '에러 메시지'를 반환
}

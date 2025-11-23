package com.example.umc9th2.global.apiPayload.code;
//재사용할 기본 성공 응답 코드
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK, "COMMON200_1", "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "COMMON201_1", "리소스가 성공적으로 생성되었습니다."),
    ACCEPTED(HttpStatus.ACCEPTED, "COMMON202_1", "요청이 수락되었습니다."),
    NO_CONTENT(HttpStatus.NO_CONTENT, "COMMON204_1", "요청이 처리되었지만 응답 본문이 없습니다.");


    private final HttpStatus status;
    private final String code;        
    private final String message; 
}

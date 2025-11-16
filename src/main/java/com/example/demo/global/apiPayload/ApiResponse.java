package com.example.demo.global.apiPayload;

import com.example.demo.global.apiPayload.code.BaseErrorCode;
import com.example.demo.global.apiPayload.code.BaseSuccessCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    private final Boolean isSuccess;
    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL) //실패 했을 때 아예 응답값에 포함시키지 않게 하는 어노테이션
    private T result;

    //성공시 응답
    public static <T> ApiResponse<T> onSuccess(BaseSuccessCode code,T result) {
        return new ApiResponse<>(true, code.getCode(), code.getMessage(), result);
    }

    //실패시 응답
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code,  T result) {
        return new ApiResponse<>(false, code.getCode(), code.getMessage(), result);
    }
}
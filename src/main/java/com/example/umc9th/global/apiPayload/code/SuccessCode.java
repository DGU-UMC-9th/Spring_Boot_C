package com.example.umc9th.global.apiPayload.code;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {

    /** 공통 성공 코드 */
    SUCCESS("요청이 성공적으로 처리되었습니다."),
    CREATED("요청이 성공적으로 처리되었으며, 리소스가 생성되었습니다."),
    READ_SUCCESS("데이터 조회에 성공했습니다."),
    UPDATE_SUCCESS("데이터 수정에 성공했습니다."),
    DELETE_SUCCESS("데이터 삭제에 성공했습니다."),

    /** 리뷰 성공 코드 */
    REVIEW_CREATED("리뷰가 성공적으로 등록되었습니다."),
    REVIEW_UPDATED("리뷰가 수정되었습니다."),
    REVIEW_DELETED("리뷰가 삭제되었습니다."),
    REVIEW_SEARCHED("리뷰 검색이 성공적으로 완료되었습니다.")
    ;

    private final String message;
}
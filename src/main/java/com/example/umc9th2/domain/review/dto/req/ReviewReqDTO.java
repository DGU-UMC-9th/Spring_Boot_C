package com.example.umc9th2.domain.review.dto.req;


import lombok.Getter;

//리뷰 생성 요청
@Getter
public class ReviewReqDTO {


    @Getter
    public static class CreateReview {
        private Integer rating;   // 평점
        private String content;
        private Long storeId;     // 가게 ID
    }
}

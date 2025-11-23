package com.example.umc9th2.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

//리뷰 생성 응답
public class ReviewResDTO {

    @Builder
    @Getter
    public static class CreateReview {
        private Long reviewId;
        private String username;  // 하드코딩된 유저
        private Integer rating;
        private String content;
        private String storeName;
    }
}

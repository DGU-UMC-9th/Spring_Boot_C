package com.example.umc9th2.domain.review.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ReviewReqDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReview {
        private Integer rating;
        private String content;
        private Long storeId;
    }
}

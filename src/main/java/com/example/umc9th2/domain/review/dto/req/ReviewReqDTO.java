package com.example.umc9th2.domain.review.dto.req;

public class ReviewReqDTO {

    public record CreateReview(
            Integer rating,
            String content,
            Long storeId
    ) {}
}

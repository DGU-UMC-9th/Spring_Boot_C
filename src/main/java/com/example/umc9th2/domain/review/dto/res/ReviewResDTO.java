package com.example.umc9th2.domain.review.dto.res;
//record 로 변경
import java.time.LocalDateTime;

public class ReviewResDTO {

    public record CreateReview(
            Long reviewId,
            String username,
            Integer rating,
            String content,
            String storeName,
            LocalDateTime createdAt
    ) {}
    //내가 작성한 review 목ㄹ곻
    public record MyReviewList(
        Long reviewId,
        String storeName,
        Integer rating,
        String content,
        LocalDateTime createdAt
) {}
}

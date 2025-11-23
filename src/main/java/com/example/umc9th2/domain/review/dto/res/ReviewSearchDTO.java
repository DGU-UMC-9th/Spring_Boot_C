package com.example.umc9th2.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

//리뷰 검색/조회
@Builder
@Getter
public class ReviewSearchDTO {
    private Long reviewId;
    private String username;
    private Integer rating;
    private String content;
    //private LocalDateTime createdAt;
}


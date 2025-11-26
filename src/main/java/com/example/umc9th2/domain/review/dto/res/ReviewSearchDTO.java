package com.example.umc9th2.domain.review.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSearchDTO {
    private Long reviewId;
    private String username;
    private Integer rating;
    private String content;
}


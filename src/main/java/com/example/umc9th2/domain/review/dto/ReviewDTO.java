package com.example.umc9th2.domain.review.dto;

//import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewDTO {
    private Long reviewId;
    private String username;
    private Integer rating;
    private String content;
    //private LocalDateTime createdAt;
}
package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    // 단일 Entity -> DTO
    public static ReviewResDto toReviewDto(Review review) {
        return ReviewResDto.builder()
                .content(review.getContent()) //
                .rating(Float.valueOf(review.getRating()))
                .build();
    }

    // Entity List -> DTO List
    public static List<ReviewResDto> toReviewListDto(List<Review> reviewList) {
        return reviewList.stream()
                .map(ReviewConverter::toReviewDto)
                .collect(Collectors.toList());
    }
}
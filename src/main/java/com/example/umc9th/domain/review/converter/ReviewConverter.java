package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.dto.ReviewReqDto;

import java.time.LocalDateTime;
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


    // 리뷰 생성 (DTO -> Entity)
    public static Review toEntity(ReviewReqDto.JoinDto request) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getScore())
                .build();
    }

    // 리뷰 생성 응답 (Entity -> DTO)
    public static ReviewResDto.CreateReviewResultDto toCreateReviewResultDto(Review review) {
        return ReviewResDto.CreateReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
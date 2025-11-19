package com.example.umc9th2.domain.review.converter;

import com.example.umc9th2.domain.review.dto.ReviewDTO;
import com.example.umc9th2.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    // Review 엔티티 -> ReviewDTO 변환
    public static ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .reviewId(review.getReviewId())
                .username(review.getUser() != null ? review.getUser().getUsername() : null)  // User 엔티티에서 username 추출
                .rating(review.getRating())
                .content(review.getContent())
                .build();                                 // Builder로 ReviewDTO 객체 생성
    }

    // Review 리스트 -> ReviewDTO 리스트 변환
    public static List<ReviewDTO> toReviewDTOList(List<Review> reviewList) {
        return reviewList.stream()
                .map(ReviewConverter::toReviewDTO)       // 각 Review를 ReviewDTO로 변환
                .collect(Collectors.toList());
    }
}
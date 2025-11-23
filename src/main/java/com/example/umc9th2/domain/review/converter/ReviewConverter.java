package com.example.umc9th2.domain.review.converter;

import com.example.umc9th2.domain.review.dto.res.ReviewSearchDTO;
import com.example.umc9th2.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th2.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th2.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;


public class ReviewConverter {
   
     //Review Entity -> ReviewSearchDTO
     
    public static ReviewSearchDTO toReviewSearchDTO(Review review) {
        return ReviewSearchDTO.builder()
                .reviewId(review.getReviewId())
                .username(review.getUser() != null ? review.getUser().getUsername() : null)
                .rating(review.getRating())
                .content(review.getContent())
                .build();
    }

    
     //Review -> ReviewSearchDTO 리스트  
     //조회
    public static List<ReviewSearchDTO> toReviewSearchDTOList(List<Review> reviewList) {
        return reviewList.stream()
                .map(ReviewConverter::toReviewSearchDTO)
                .collect(Collectors.toList());
    }

    // 생성
    // 요청 DTO->  Review Entity
  
    public static Review toReview(ReviewReqDTO.CreateReview request) {
        Review review = new Review();
        review.setRating(request.getRating());
        review.setContent(request.getContent());
        return review;
    }

    
     //Review Entity -> 응답 DTO
    public static ReviewResDTO.CreateReview toCreateReviewDTO(Review review) {
        return ReviewResDTO.CreateReview.builder()
                .reviewId(review.getReviewId())
                .username(review.getUser() != null ? review.getUser().getUsername() : null)
                .rating(review.getRating())
                .content(review.getContent())
                .storeName(review.getStore() != null ? review.getStore().getStoreName() : null)
                .build();
    }
}
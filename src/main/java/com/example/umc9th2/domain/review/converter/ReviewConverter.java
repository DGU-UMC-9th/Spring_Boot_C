package com.example.umc9th2.domain.review.converter;

import com.example.umc9th2.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th2.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th2.domain.review.dto.res.ReviewSearchDTO;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.store.entity.Store;

import java.time.LocalDateTime;
import java.util.List;
//2차 : Builder 사용

public class ReviewConverter {

    
 //단일 Entity -> 검색 결과 DTO
  
    public static ReviewSearchDTO toReviewSearchDTO(Review review) {
        return new ReviewSearchDTO(
                review.getReviewId(),
                review.getUser() != null ? review.getUser().getUsername() : null,
                review.getRating(),
                review.getContent()
        );
    }

    
     //Review -> ReviewSearchDTO 리스트  
     //조회
    public static List<ReviewSearchDTO> toReviewSearchDTOList(List<Review> reviewList) {
        return reviewList.stream()
                .map(ReviewConverter::toReviewSearchDTO)
                .toList();
    }

    
     //리뷰 생성 요청 DTO → Review 엔티티로 변환
    
    
    public static Review toEntity(ReviewReqDTO.CreateReview request, User user, Store store) {
        return Review.builder()
                .rating(request.rating())
                .content(request.content())
                .user(user)
                .store(store)
                .build();
    }

   // 리뷰 생성 응답 DTO
    
    public static ReviewResDTO.CreateReview toCreateReviewResultDto(Review review) {
        return new ReviewResDTO.CreateReview(
                review.getReviewId(),
                review.getUser() != null ? review.getUser().getUsername() : null,
                review.getRating(),
                review.getContent(),
                review.getStore() != null ? review.getStore().getStoreName() : null,
                LocalDateTime.now()
        );
    }
}
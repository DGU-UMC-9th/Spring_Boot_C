package com.example.umc9th2.domain.review.controller;

import com.example.umc9th2.domain.review.converter.ReviewConverter;
import com.example.umc9th2.domain.review.dto.ReviewDTO;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.service.ReviewQueryService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public ApiResponse<List<ReviewDTO>> searchReviews( //#1
            @RequestParam String type,
            @RequestParam String query
    ) {
        // 응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        
        // Service에서 Review 엔티티 리스트 조회
        List<Review> reviewList = reviewQueryService.searchReview(type, query);

        //Review 엔티티 리스트 -> ReviewDTO 리스트로 변환
        List<ReviewDTO> result = ReviewConverter.toReviewDTOList(reviewList);

        return ApiResponse.onSuccess(code, result);
    }
}
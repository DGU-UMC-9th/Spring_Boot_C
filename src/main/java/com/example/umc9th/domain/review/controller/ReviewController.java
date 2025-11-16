package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewQueryService;

    // 워크북 예시
    @GetMapping("/reviews/search")
    public ApiResponse<List<ReviewResDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> reviewList = reviewQueryService.searchReview(query, type);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        List<ReviewResDto> dtoList = ReviewConverter.toReviewListDto(reviewList);
        return ApiResponse.onSuccess(code, dtoList);
    }

    // 미션
    @GetMapping("/reviews/my-reviews")
    public ApiResponse<List<ReviewResDto>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ) {
        List<Review> reviewList = reviewQueryService.getMyReviews(memberId, query, type);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        List<ReviewResDto> dtoList = ReviewConverter.toReviewListDto(reviewList);
        return ApiResponse.onSuccess(code, dtoList);
    }
}
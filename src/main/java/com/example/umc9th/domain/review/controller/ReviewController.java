package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewReqDto;
import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewCreateService;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewQueryService;
    private final ReviewCreateService reviewCreateService;

    // 워크북 예시
    @GetMapping("/search")
    public ApiResponse<List<ReviewResDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> reviewList = reviewQueryService.searchReview(query, type);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        List<ReviewResDto> dtoList = ReviewConverter.toReviewListDto(reviewList);
        return ApiResponse.onSuccess(dtoList);
    }

    // 미션
    @GetMapping("/my-reviews")
    public ApiResponse<List<ReviewResDto>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ) {
        List<Review> reviewList = reviewQueryService.getMyReviews(memberId, query, type);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        List<ReviewResDto> dtoList = ReviewConverter.toReviewListDto(reviewList);
        return ApiResponse.onSuccess(dtoList);
    }

    // 가게에 리뷰 추가
    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResDto.CreateReviewResultDto> createReview(
            @PathVariable Long storeId,
            @RequestBody @Valid ReviewReqDto.JoinDto request
    ) {
        Review review = reviewCreateService.createReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDto(review));
    }
}
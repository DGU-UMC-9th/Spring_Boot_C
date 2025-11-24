package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewCreateReqDto;
import com.example.umc9th.domain.review.dto.ReviewSearchResDto;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewQueryService reviewQueryService;
    private final ReviewService reviewService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<ReviewSearchResDto>> searchReviews(
            @RequestParam String type,
            @RequestParam String query
    ) {
        ReviewSearchResDto result = reviewQueryService.searchReview(type, query);
        return ResponseEntity.ok(ApiResponse.onSuccess(SuccessCode.READ_SUCCESS, result));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<ReviewCreateReqDto>> createReview(@RequestBody ReviewCreateReqDto req) {
        long userId = 1; //임시 유저
        reviewService.createReview(req, userId);

        return ResponseEntity.ok(ApiResponse.onSuccess(SuccessCode._CREATED));
    }


}

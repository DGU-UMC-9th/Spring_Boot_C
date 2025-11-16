package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewSearchResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<ReviewSearchResDto>> searchReviews(
            @RequestParam String type,
            @RequestParam String query
    ) {
        ReviewSearchResDto result = reviewQueryService.searchReview(type, query);
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.REVIEW_SEARCHED, result));
    }
}

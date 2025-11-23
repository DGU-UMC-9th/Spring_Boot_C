package com.example.umc9th2.domain.review.controller;

import com.example.umc9th2.domain.review.converter.ReviewConverter;
import com.example.umc9th2.domain.review.dto.res.ReviewSearchDTO;
import com.example.umc9th2.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th2.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.service.ReviewCommandService;
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
    private final ReviewQueryService reviewQueryService;      // 조회
    private final ReviewCommandService reviewCommandService;  // 생성/수정/삭제

    //검색
    @GetMapping("/search")
    public ApiResponse<List<ReviewSearchDTO>> searchReviews(
            @RequestParam String type,
            @RequestParam String query
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        List<Review> reviewList = reviewQueryService.searchReview(type, query);
        List<ReviewSearchDTO> result = ReviewConverter.toReviewSearchDTOList(reviewList);
        return ApiResponse.onSuccess(code, result);
    }

    //생성
    @PostMapping
    public ApiResponse<ReviewResDTO.CreateReview> createReview(
            @RequestBody ReviewReqDTO.CreateReview request
    ) {
 
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        ReviewResDTO.CreateReview result = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(code, result);
    }
}
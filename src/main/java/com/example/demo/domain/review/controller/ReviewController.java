package com.example.demo.domain.review.controller;


import com.example.demo.domain.review.dto.ReviewResponseDTO;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.review.service.ReviewService;
import com.example.demo.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/my")
    public ApiResponse<List<ReviewResponseDTO>> getMyReviews(
            // @AuthenticationPrincipal User user, 로그인 기능 구현시 추가
            @RequestParam(required = false) Long storeId,
            @RequestParam(required = false) float starRating
    ) {
        // Long currentUserId = user.getId(); 실제 유저 ID
        Long tempUserId = 1L; // 임시 유저 ID

        List<Review> reviews = reviewService.getMyReviews(tempUserId, storeId, starRating);

        List<ReviewResponseDTO> dtoList = reviews.stream()
                .map(ReviewResponseDTO::new)
                .toList();

        return ApiResponse.onSuccess(dtoList);
    }
}

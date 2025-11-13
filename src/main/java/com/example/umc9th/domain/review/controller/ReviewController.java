package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewService;
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
    public List<Review> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> result = reviewQueryService.searchReview(query, type);
        return result;
    }

    // 미션
    @GetMapping("/reviews/my-reviews")
    public List<Review> getMyReviews(
            @RequestParam Long memberId,
            // "가게별", "별점별" 필터는 '선택 사항'이므로, 'required = false'를 추가 (이 파라미터가 없어도 API가 작동)
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ) {
        // Service에 'memberId'와 필터(query, type)를 전달
        return reviewQueryService.getMyReviews(memberId, query, type);
    }
}

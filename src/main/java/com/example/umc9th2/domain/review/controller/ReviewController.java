package com.example.umc9th2.domain.review.controller;

import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public ResponseEntity<List<Review>> searchReviews(
            @RequestParam String type,
            @RequestParam String query,
            @RequestParam(required = false) Float star
    ) {
        List<Review> result = reviewQueryService.searchReview(type, query,star);
        return ResponseEntity.ok(result);
    }
}
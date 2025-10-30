package com.example.umc9th2.domain.review.controller;

import com.example.umc9th2.domain.review.dto.ReviewDTO;
import com.example.umc9th2.domain.review.service.ReviewService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public Page<ReviewDTO> getReviewList(
            @RequestParam Long missionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return reviewService.getReviewList(missionId, pageable);
    }
}

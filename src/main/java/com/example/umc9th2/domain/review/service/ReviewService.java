package com.example.umc9th2.domain.review.service;

import com.example.umc9th2.domain.review.dto.ReviewDTO;
import com.example.umc9th2.domain.review.repository.ReviewRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Page<ReviewDTO> getReviewList(Long missionId, Pageable pageable) {
        return reviewRepository.findReviewsByMissionId(missionId, pageable);
    }
}

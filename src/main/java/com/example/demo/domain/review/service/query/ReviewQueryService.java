package com.example.demo.domain.review.service.query;

import com.example.demo.domain.review.dto.res.ReviewResDTO;

import java.util.List;

public interface ReviewQueryService {
    void checkFlag(Long flag);

    List<ReviewResDTO.ReviewResponse> getMyReviews(Long userId, Long storeId, Double starRating);
}

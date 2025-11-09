package com.example.umc9th2.domain.review.repository;

import com.example.umc9th2.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {
    List<Review> searchReview(Predicate predicate);
}

package com.example.demo.domain.review.service;

import com.example.demo.domain.review.dto.ReviewResponseDTO;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.domain.review.entity.QReview.review;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getMyReviews(Long currentUserId, Long filterStoreId, Float filterStarRating) {

        BooleanBuilder builder = new BooleanBuilder();

        builder.and(review.member.id.eq(currentUserId));

        if(filterStoreId != null) {
            builder.and(review.store.id.eq(filterStoreId));
        }
        if(filterStarRating != null) {
            builder.and(review.star.eq(filterStarRating));
        }
        return reviewRepository.searchReview(builder);
    }
}

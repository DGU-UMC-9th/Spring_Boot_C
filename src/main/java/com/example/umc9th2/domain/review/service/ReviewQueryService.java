package com.example.umc9th2.domain.review.service;

import com.example.umc9th2.domain.review.dto.res.ReviewSearchDTO;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.entity.QReview;
import com.example.umc9th2.domain.review.repository.ReviewRepository;
import com.example.umc9th2.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(String type, String query) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

      
        if (type.equals("store")) {
            builder.and(review.store.storeName.contains(query));
        }

        if (type.equals("content")) {
            builder.and(review.content.contains(query));
        }

        if (type.equals("both")) {
            String[] queries = query.split("&");
            String firstQuery = queries[0];  
            String secondQuery = queries[1];  
            builder.and(review.store.storeName.contains(firstQuery));
            builder.and(review.content.contains(secondQuery));
        }

        List<Review> reviewList = reviewRepository.searchReview(builder);
        return reviewList;
    }
    public Page<Review> getMyReviews(Long userId, Pageable pageable) {
        return reviewRepository.findByUser_UserId(userId, pageable);
    }
}

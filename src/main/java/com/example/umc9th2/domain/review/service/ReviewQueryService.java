package com.example.umc9th2.domain.review.service;

import com.example.umc9th2.domain.review.dto.ReviewDTO;
import com.example.umc9th2.domain.review.entity.QReview;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.repository.ReviewRepository;
import com.example.umc9th2.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(String type, String query,Float star) {

        QReview review = QReview.review;
        QStore store = QStore.store;
        BooleanBuilder builder = new BooleanBuilder();

        // 가게명 필터
        if (type.equals("store") && query != null) {
            builder.and(review.store.storeName.contains(query));
        }

        //  별점 필터
        if (type.equals("star") && star != null) {
            builder.and(review.rating.goe(star));
        }

        // 가게 + 별점 동시
        if (type.equals("both") && query != null && star != null) {
            builder.and(review.store.storeName.contains(query));
            builder.and(review.rating.goe(star));
        }

        // 최종 Predicate로 전달
        return reviewRepository.searchReview(builder);
    }
}
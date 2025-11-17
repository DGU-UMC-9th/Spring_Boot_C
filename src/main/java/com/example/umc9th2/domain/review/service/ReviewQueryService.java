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

    public List<Review> searchReview(String type, String query) {

        // Q클래스 정의
        QReview review = QReview.review;

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // 동적 쿼리 조건
        if (type.equals("store")) {
            builder.and(review.store.storeName.contains(query));
        }

        if (type.equals("content")) {
            builder.and(review.content.contains(query));
        }

        if (type.equals("both")) {
            String[] queries = query.split("&");
            String firstQuery = queries[0];   // storeName 검색값
            String secondQuery = queries[1];  // content 검색값

            builder.and(review.store.storeName.contains(firstQuery));
            builder.and(review.content.contains(secondQuery));
        }

        // Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.searchReview(builder);

        // return
        return reviewList;
    }
}

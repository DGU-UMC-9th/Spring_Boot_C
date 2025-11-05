package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(String type, String query){
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // 가게별 조회
        if ("restaurantId".equals(type)) {
            Long restaurantId = Long.parseLong(query);
            builder.and(review.restaurant.id.eq(restaurantId));
        }

        // 평점대 조회 (ex 3점대 : 3.0 ≤ rating < 4.0)
        else if ("rating".equals(type)) {
            int baseRating = Integer.parseInt(query);
            float lower = baseRating;
            float upper = baseRating + 1;

            builder.and(review.rating.goe(lower)); // rating >= 3.0
            builder.and(review.rating.lt(upper));  // rating < 4.0
        }

        // 잘못된 type
        else {
            throw new IllegalArgumentException("type은 'restaurantId' 또는 'rating' 중 하나여야 합니다.");
        }

        return reviewRepository.searchReview(builder);
    }
}

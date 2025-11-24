package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.restaurants.entity.Restaurant;
import com.example.umc9th.domain.restaurants.repository.RestaurantRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewCreateReqDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createReview(ReviewCreateReqDto reqDto, long userId){
        // User 엔티티 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.USER_NOT_FOUND));

        // Restaurant 엔티티 조회
        Restaurant restaurant = restaurantRepository.findById(reqDto.getRestaurantId())
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND)); // RESTAURANT_NOT_FOUND가 없으면 NOT_FOUND 사용

        // Converter를 사용하여 Review
        Review review = ReviewConverter.toReview(reqDto, user, restaurant);

        // 4. 저장
        reviewRepository.save(review);
    }
}

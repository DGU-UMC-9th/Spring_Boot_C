package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.restaurants.entity.Restaurant;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public void createReview(Restaurant restaurant, User user, int rating, String content){

        Review review = Review.builder()
                .user(user)
                .rating(rating)
                .content(content)
                .restaurant(restaurant)
                .build();

        reviewRepository.save(review);
    }
}

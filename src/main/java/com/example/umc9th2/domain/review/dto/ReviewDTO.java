package com.example.umc9th2.domain.review.dto;

import java.time.LocalDateTime;

public class ReviewDTO{
    private final Long reviewId;
    private final String username;
    private final Integer rating;
    private final String content;
  //  private final LocalDateTime createdAt;

    public ReviewDTO(Long reviewId, String username, Integer rating, String content /*,LocalDateTime createdAt*/) {
        this.reviewId = reviewId;
        this.username = username;
        this.rating = rating;
        this.content = content;
        //this.createdAt = createdAt;
    }
    public Long getReviewId() { return reviewId; }
    public String getUsername() { return username; }
    public Integer getRating() { return rating; }
    public String getContent() { return content; }
    //public LocalDateTime getCreatedAt() { return createdAt; }
}
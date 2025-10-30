package com.example.umc9th2.domain.user.dto;

public class MyPageDTO {
    private final Long userId;
    private final String username;
    private final String email;
    private final Integer totalPoints;
    private final Long writtenReviews;

    public MyPageDTO(Long userId, String username, String email, Integer totalPoints, Long writtenReviews) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.totalPoints = totalPoints;
        this.writtenReviews = writtenReviews;
    }
    public Long getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public Integer getTotalPoints() { return totalPoints; }
    public Long getWrittenReviews() { return writtenReviews; }
}
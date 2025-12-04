package com.example.umc9th2.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageDTO {
    private final Long userId;
    private final String username;
    private final String email;
    private final Integer totalPoints;
    private final Long writtenReviews;
}
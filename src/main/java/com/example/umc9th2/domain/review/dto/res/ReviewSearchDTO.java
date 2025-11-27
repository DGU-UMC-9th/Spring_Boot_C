package com.example.umc9th2.domain.review.dto.res;

public record ReviewSearchDTO(
        Long reviewId,
        String username,
        Integer rating,
        String content
) {}


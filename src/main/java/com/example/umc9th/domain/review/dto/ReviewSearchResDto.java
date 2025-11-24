package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReviewSearchResDto {
    private long id;
    private String restaurantName;
    private List<ReviewDetailDto> reviews;
}

package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class ReviewDetailDto {
    private String nickname;
    private float rating;
    private String content;
    private LocalDate createdAt;
    private List<String> reviewImages;
}

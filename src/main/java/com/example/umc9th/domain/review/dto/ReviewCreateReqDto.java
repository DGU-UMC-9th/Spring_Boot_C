package com.example.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ReviewCreateReqDto {
    private long restaurantId;
    private String content;
    private float rating;
    private List<String> imgUrl;
}

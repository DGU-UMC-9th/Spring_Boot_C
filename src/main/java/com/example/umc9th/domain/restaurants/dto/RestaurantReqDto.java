package com.example.umc9th.domain.restaurants.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RestaurantReqDto {
    private String name;
    private String detailAddress;
    private String category;
    private Long locationId;
}
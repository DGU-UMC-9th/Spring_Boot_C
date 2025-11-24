package com.example.umc9th.domain.restaurants.converter;

import com.example.umc9th.domain.restaurants.dto.RestaurantReqDto;
import com.example.umc9th.domain.restaurants.entity.Location;
import com.example.umc9th.domain.restaurants.entity.Restaurant;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantReqDto reqDto, Location location) {
        return Restaurant.builder()
                .name(reqDto.getName())
                .detailAddress(reqDto.getDetailAddress())
                .category(reqDto.getCategory())
                .location(location)
                .build();
    }
}
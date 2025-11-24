package com.example.umc9th.domain.restaurants.service;

import com.example.umc9th.domain.restaurants.converter.RestaurantConverter;
import com.example.umc9th.domain.restaurants.dto.RestaurantReqDto;
import com.example.umc9th.domain.restaurants.entity.Location;
import com.example.umc9th.domain.restaurants.entity.Restaurant;
import com.example.umc9th.domain.restaurants.repository.LocationRepository;
import com.example.umc9th.domain.restaurants.repository.RestaurantRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public Restaurant createRestaurant(RestaurantReqDto reqDto) {
        Location location = locationRepository.findById(reqDto.getLocationId())
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        Restaurant restaurant = RestaurantConverter.toRestaurant(reqDto, location);

        return restaurantRepository.save(restaurant);
    }
}
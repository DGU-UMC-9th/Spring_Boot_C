package com.example.umc9th.domain.restaurants.controller;

import com.example.umc9th.domain.restaurants.dto.RestaurantReqDto;
import com.example.umc9th.domain.restaurants.entity.Restaurant;
import com.example.umc9th.domain.restaurants.service.RestaurantService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createRestaurant(
            @RequestBody RestaurantReqDto request
    ) {
        Restaurant newRestaurant = restaurantService.createRestaurant(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(SuccessCode._CREATED, newRestaurant.getId()));
    }
}

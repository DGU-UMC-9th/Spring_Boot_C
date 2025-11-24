package com.example.umc9th.domain.restaurants.repository;

import com.example.umc9th.domain.restaurants.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

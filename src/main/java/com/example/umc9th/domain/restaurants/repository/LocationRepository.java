package com.example.umc9th.domain.restaurants.repository;

import com.example.umc9th.domain.restaurants.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

package com.example.umc9th2.domain.store.repository;

import com.example.umc9th2.domain.store.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

//Region Entity 데이터베이스 접근을 담당
public interface RegionRepository extends JpaRepository<Region, Long> {
}
package com.example.umc9th2.domain.store.repository;

import com.example.umc9th2.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

// Store Entity 데이터베이스 접근 담당
public interface StoreRepository extends JpaRepository<Store, Long> {
}
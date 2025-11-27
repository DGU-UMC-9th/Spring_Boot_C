package com.example.umc9th2.domain.user.dto;

import java.time.LocalDateTime;

public record MyMissionDTO(
        Long missionId,
        String title,
        String description,
        Integer rewardPoints,
        String status,
        LocalDateTime clearedAt,
        String storeName,
        String regionName
) {}
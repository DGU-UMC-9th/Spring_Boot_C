package com.example.umc9th2.domain.user.dto;

import java.time.LocalDateTime;

public record MyMissionDTO(
        Long missionId,
        String title,
        String description,
        Integer rewardPoints,
        boolean status,    // String에서 바꿈
        LocalDateTime clearedAt,
        String storeName,
        String regionName
) {}
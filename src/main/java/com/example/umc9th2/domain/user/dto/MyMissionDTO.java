package com.example.umc9th2.domain.user.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyMissionDTO {
    private final Long missionId;
    private final String title;
    private final String description;
    private final Integer rewardPoints;
    private final String status;
    private final LocalDateTime clearedAt;
    private final String storeName;
    private final String regionName;
}
package com.example.umc9th2.domain.user.dto;

import java.time.LocalDateTime;

public class MyMissionDTO {
    private final Long missionId;
    private final String title;
    private final String description;
    private final Integer rewardPoints;
    private final String status;
    private final LocalDateTime clearedAt;
    private final String storeName;
    private final String regionName;

    public MyMissionDTO(Long missionId, String title, String description, Integer rewardPoints,
                                 String status, LocalDateTime clearedAt, String storeName, String regionName) {
        this.missionId = missionId;
        this.title = title;
        this.description = description;
        this.rewardPoints = rewardPoints;
        this.status = status;
        this.clearedAt = clearedAt;
        this.storeName = storeName;
        this.regionName = regionName;
    }
    public Long getMissionId() { return missionId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Integer getRewardPoints() { return rewardPoints; }
    public String getStatus() { return status; }
    public LocalDateTime getClearedAt() { return clearedAt; }
    public String getStoreName() { return storeName; }
    public String getRegionName() { return regionName; }
}
package com.example.umc9th2.domain.mission.dto;


public class HomeMission {
    private final Long missionId;
    private final String title;
    private final String description;
    private final Integer rewardPoints;
    private final String storeName;
    private final String status;

    public HomeMission(Long missionId, String title, String description, Integer rewardPoints,
                       String storeName, String status) {
        this.missionId = missionId;
        this.title = title;
        this.description = description;
        this.rewardPoints = rewardPoints;
        this.storeName = storeName;
        this.status = status;
    }

    public Long getMissionId() { return missionId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Integer getRewardPoints() { return rewardPoints; }
    public String getStoreName() { return storeName; }
    public String getStatus() { return status; }
}


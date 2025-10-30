
package com.example.umc9th2.domain.mission.dto;

public class HomeMission{
    private final Long missionId;
    private final String title;
    private final String description;
    private final Integer rewardPoints;
    private final String storeName;
    private final String userStatus;

    public HomeMission(Long missionId, String title, String description,
                               Integer rewardPoints, String storeName, String userStatus) {
        this.missionId = missionId;
        this.title = title;
        this.description = description;
        this.rewardPoints = rewardPoints;
        this.storeName = storeName;
        this.userStatus = userStatus;
    }
    // getter 생략 가능 (롬복 @Getter도 OK)
    public Long getMissionId() { return missionId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Integer getRewardPoints() { return rewardPoints; }
    public String getStoreName() { return storeName; }
    public String getUserStatus() { return userStatus; }
}
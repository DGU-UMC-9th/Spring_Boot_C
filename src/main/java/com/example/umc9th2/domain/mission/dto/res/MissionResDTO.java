package com.example.umc9th2.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMission {
        private Long missionId;
        private String title;
        private String description;
        private Integer rewardPoints;
        private String storeName;
    }
}
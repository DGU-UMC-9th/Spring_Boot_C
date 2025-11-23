package com.example.umc9th2.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;

//미션 응답 DTO
public class MissionResDTO {

    @Builder
    @Getter
    public static class CreateMission {
        private Long missionId;
        private String title;
        private String description;
        private Integer rewardPoints;
        private String storeName;
    }
}
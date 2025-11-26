package com.example.umc9th2.domain.user.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserMissionResDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeMission {
        private Long userMissionId;
        private Long missionId;
        private String missionTitle;
        private String status;
        private LocalDateTime createdAt;
    }
}
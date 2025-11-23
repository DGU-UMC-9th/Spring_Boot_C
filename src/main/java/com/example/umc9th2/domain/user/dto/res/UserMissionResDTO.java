package com.example.umc9th2.domain.user.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


public class UserMissionResDTO {
// 미션 도전 응답 데이터
    @Builder
    @Getter
    public static class ChallengeMission {
        private Long userMissionId;
        private Long missionId;
        private String missionTitle;
        private String status;
        private LocalDateTime createdAt;
    }
}
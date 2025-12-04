package com.example.umc9th2.domain.user.dto.res;

import java.time.LocalDateTime;

public class UserMissionResDTO {

    public record ChallengeMission(
            Long userMissionId,
            Long missionId,
            String missionTitle,
            boolean status,
            LocalDateTime createdAt
    ) {}
}
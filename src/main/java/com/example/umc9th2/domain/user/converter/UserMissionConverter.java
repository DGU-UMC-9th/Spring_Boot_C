package com.example.umc9th2.domain.user.converter;

import com.example.umc9th2.domain.user.dto.res.UserMissionResDTO;
import com.example.umc9th2.domain.user.entity.mapping.UserMission;


public class UserMissionConverter {
     //UserMission Entity->응답 DTO
    public static UserMissionResDTO.ChallengeMission toChallengeMissionDTO(UserMission userMission) {
        return UserMissionResDTO.ChallengeMission.builder()
                .userMissionId(userMission.getUserMissionId())
                .missionId(userMission.getMission().getMissionId())
                .missionTitle(userMission.getMission().getTitle())
                .status(userMission.getStatus())
                .createdAt(null)
                .build();
    }
}
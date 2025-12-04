package com.example.umc9th2.domain.user.converter;

import com.example.umc9th2.domain.user.dto.res.UserMissionResDTO;
import com.example.umc9th2.domain.user.entity.mapping.UserMission;

// 단방향으로 함. 엔티티 생성은 service 에서 하는 걸로 함.
public class UserMissionConverter {
     //UserMission Entity->응답 DTO
    public static UserMissionResDTO.ChallengeMission toChallengeMissionDTO(UserMission userMission) {
        return new UserMissionResDTO.ChallengeMission(
                userMission.getUserMissionId(),
                userMission.getMission().getMissionId(),
                userMission.getMission().getTitle(),
                userMission.isStatus(),
                null
        );
    }
}
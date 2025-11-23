package com.example.umc9th2.domain.mission.converter;

import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.Mission;


public class MissionConverter {


    //요청 DTO -> Entity
    public static Mission toMission(MissionReqDTO.CreateMission request) {
        Mission mission = new Mission();
        mission.setTitle(request.getTitle());
        mission.setDescription(request.getDescription());
        mission.setRewardPoints(request.getRewardPoints());
        mission.setIsActive(true);  // 생성 시 활성 상태로 설정
        return mission;
    }

   //Entity -> 응답 DTO
    public static MissionResDTO.CreateMission toCreateMissionDTO(Mission mission) {
        return MissionResDTO.CreateMission.builder()
                .missionId(mission.getMissionId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .rewardPoints(mission.getRewardPoints())
                .storeName(mission.getStore() != null ? mission.getStore().getStoreName() : null)
                .build();
    }
}
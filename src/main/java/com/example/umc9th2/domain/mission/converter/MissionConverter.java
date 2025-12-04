package com.example.umc9th2.domain.mission.converter;

import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.Mission;
import com.example.umc9th2.domain.store.entity.Store;

public class MissionConverter {

// DTO -> Entity 변환 (미션 생성)
    
    public static Mission toMission(MissionReqDTO reqDto, Store store) {
        return Mission.builder()
                .title(reqDto.title())
                .description(reqDto.description())
                .rewardPoints(reqDto.rewardPoints())
                .store(store)
                .build();
    }

    // Entity -> DTO 변환 (생성 응답)
    
    public static MissionResDTO.CreateMission toCreateMissionDTO(Mission mission) {
        return new MissionResDTO.CreateMission(
                mission.getMissionId(),
                mission.getTitle(),
                mission.getDescription(),
                mission.getRewardPoints(),
                mission.getStore().getStoreName()
        );
    }

// 미션목록반환 
public static List<MissionResDTO.MissionList> toMissionListDTO(List<Mission> missionList) {
    return missionList.stream()
            .map(mission -> new MissionResDTO.MissionList(
                    mission.getMissionId(),
                    mission.getTitle(),
                    mission.getDescription(),
                    mission.getRewardPoints(),
                    mission.getIsActive()
            ))
            .toList();
}
}
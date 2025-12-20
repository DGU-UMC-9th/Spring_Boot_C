package com.example.umc9th2.domain.mission.dto.res;

// static -> record 로 바꿔봄
public class MissionResDTO {

    public record CreateMission(
            Long missionId,
            String title,
            String description,
            Integer rewardPoints,
            String storeName //store 에서 
    ) {}
    //미션 week 9 
    public record MissionList(
        Long missionId,
        String title,
        String description,
        Integer rewardPoints,
        Boolean isActive
) {}
}
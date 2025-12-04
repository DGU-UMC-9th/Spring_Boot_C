package com.example.umc9th2.domain.mission.dto.req;
// record 로 변경ㅇ
public record MissionReqDTO(
        String title,
        String description,
        Integer rewardPoints,
        Long storeId
) {}
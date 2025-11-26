package com.example.umc9th2.domain.mission.converter;

import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.entity.Mission;
import com.example.umc9th2.domain.store.entity.Store;

public class MissionConverter {

    private MissionConverter() {
    }

    public static Mission toMission(MissionReqDTO request, Store store) {
        return Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .rewardPoints(request.getRewardPoints())
                .store(store)
                .build();
    }
}
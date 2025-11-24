package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MissionReqDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.restaurants.entity.Restaurant;

public class MissionConverter {

    public static Mission toMission(MissionReqDto reqDto, Restaurant restaurant) {
        return Mission.builder()
                .deadline(reqDto.getDeadline())
                .content(reqDto.getContent())
                .point(reqDto.getPoint())
                .restaurant(restaurant)
                .build();
    }
}


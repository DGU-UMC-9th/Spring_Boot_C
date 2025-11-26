package com.example.umc9th2.domain.mission.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionReqDTO {

    private String title;
    private String description;
    private Integer rewardPoints;
    private Long storeId;
}
package com.example.umc9th2.domain.mission.dto.res;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HomeMissionResDTO {
    private Long missionId;
    private String title;
    private String description;
    private Integer rewardPoints;
    private String storeName;
    private String status;
}


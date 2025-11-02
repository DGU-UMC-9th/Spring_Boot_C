package com.example.umc9th.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserMissionResDto {
    private Long missionId;

    private float missionPoint;

    private String restaurantName;

    private String missionContent;

    private boolean isDone;
}

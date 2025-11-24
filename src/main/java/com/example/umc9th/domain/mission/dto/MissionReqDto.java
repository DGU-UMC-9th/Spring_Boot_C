package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Builder
@Getter
public class MissionReqDto {
    private Long restaurantId;
    private Date deadline;
    private String content;
    private float point;
}

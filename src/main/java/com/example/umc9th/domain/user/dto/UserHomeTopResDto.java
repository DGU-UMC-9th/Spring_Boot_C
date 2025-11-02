package com.example.umc9th.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserHomeTopResDto {
    private String address;

    private int totalPoint;

    private long completedMissionCount;
}


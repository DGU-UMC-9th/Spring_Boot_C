package com.example.umc9th.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
public class UserHomeResDto {
    private UserHomeTopResDto topInfo;

    private Page<UserMissionResDto> myMissions;
}
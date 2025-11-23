package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.converter.MemberMissionConverter;
import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.service.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    // API: 가게의 미션을 도전 중인 미션에 추가
    // URL: POST /missions/{missionId}/challenge
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MemberMissionResDto.CreateMemberMissionResultDto> challengeMission(
            @PathVariable Long missionId
    ) {

        MemberMission memberMission = missionCommandService.challengeMission(missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateResultDto(memberMission));
    }
}
package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.Mission;
import com.example.umc9th2.domain.mission.service.MissionService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    /**
     * 미션 생성
     */
    @PostMapping
    public ApiResponse<MissionResDTO.CreateMission> createMission(
            @RequestBody MissionReqDTO request
    ) {
        Mission mission = missionService.createMission(request);
        MissionResDTO.CreateMission result = MissionResDTO.CreateMission.builder()
                .missionId(mission.getMissionId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .rewardPoints(mission.getRewardPoints())
                .storeName(mission.getStore().getStoreName())
                .build();
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }
}

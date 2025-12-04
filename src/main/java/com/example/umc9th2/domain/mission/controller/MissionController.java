package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.converter.MissionConverter;
import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th2.domain.mission.service.MissionService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {

    private final MissionService missionService;

    /**
     * 미션 생성
     */
    @PostMapping
    public ApiResponse<MissionResDTO.CreateMission> createMission(
            @RequestBody MissionReqDTO request
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                MissionConverter.toCreateMissionDTO(
                        missionService.createMission(request)
                )
        );
    }
}

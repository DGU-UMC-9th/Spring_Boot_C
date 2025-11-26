package com.example.demo.domain.mission.controller;


import com.example.demo.domain.member.entity.mapping.MemberMission;
import com.example.demo.domain.mission.converter.MemberMissionConverter;
import com.example.demo.domain.mission.dto.req.MissionReqDTO;
import com.example.demo.domain.mission.dto.res.MissionResDTO;
import com.example.demo.domain.mission.service.command.MissionCommandService;
import com.example.demo.global.apiPayload.ApiResponse;
import com.example.demo.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    // 미션 목록에 추가 API
    @PostMapping("/add")
    public ApiResponse<MissionResDTO.MissionJoinResultDto> joinMission(
            @RequestBody  MissionReqDTO.MissionJoinDto request) {

        MemberMission memberMission = missionCommandService.joinMission(request);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code,MemberMissionConverter.toJoinResultDto(memberMission));
    }
}

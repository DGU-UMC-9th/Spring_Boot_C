package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.dto.res.HomeMissionResDTO;
import com.example.umc9th2.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th2.domain.mission.service.MissionService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }
//홈화면목록조회
    @GetMapping("/home")
    public List<HomeMissionResDTO> getHomeMissions(
            @RequestParam Long userId,
            @RequestParam Long regionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return missionService.getHomeMissions(userId, regionId, pageable);
    }
    //미션 생성
    @PostMapping
    public ApiResponse<MissionResDTO.CreateMission> createMission(
            @RequestBody MissionReqDTO.CreateMission request
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        MissionResDTO.CreateMission result = missionService.createMission(request);
        return ApiResponse.onSuccess(code, result);
    }
}


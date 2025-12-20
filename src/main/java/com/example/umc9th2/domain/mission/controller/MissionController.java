package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.converter.MissionConverter;
import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th2.domain.mission.service.MissionService;
import com.example.umc9th2.global.annotation.ValidPage;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {

    private final MissionService missionService;


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

    //특정가게의미션을 조회
    @GetMapping("/stores/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회", description = "특정 가게에 등록된 미션 목록을 페이징하여 조회합니다.")
    public ApiResponse<List<MissionResDTO.MissionList>> getStoreMissions(
            @PathVariable Long storeId,
            @ValidPage @RequestParam Integer page
    ) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<com.example.umc9th2.domain.mission.entity.Mission> missionPage = missionService.getStoreMissions(storeId, pageable);
        List<MissionResDTO.MissionList> result = MissionConverter.toMissionListDTO(missionPage.getContent());
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}

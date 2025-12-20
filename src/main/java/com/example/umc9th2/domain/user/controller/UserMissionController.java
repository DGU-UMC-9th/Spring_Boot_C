package com.example.umc9th2.domain.user.controller;

import com.example.umc9th2.domain.user.dto.MyMissionDTO;
import com.example.umc9th2.domain.user.dto.res.UserMissionResDTO;
import com.example.umc9th2.domain.user.service.UserMissionService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/my-missions")
@RequiredArgsConstructor
public class UserMissionController {

    private final UserMissionService userMissionService;

    @GetMapping
    public List<MyMissionDTO> getMyMissions(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return userMissionService.getMyMissions(userId, pageable);
    }
    //미션도전
    @PostMapping("/challenge/{missionId}")
    public ApiResponse<UserMissionResDTO.ChallengeMission> challengeMission(
            @PathVariable Long missionId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        UserMissionResDTO.ChallengeMission result = userMissionService.challengeMission(missionId);
        return ApiResponse.onSuccess(code, result);
    }
    //진행중인 미션목록죄회
    @GetMapping("/in-progress")
    @Operation(summary = "내가 진행중인 미션 목록 조회", description = "특정 사용자가 진행중인 미션 목록을 페이징하여 조회합니다.")
    public ApiResponse<List<MyMissionDTO>> getInProgressMissions(
            @RequestParam Long userId,
            @ValidPage @RequestParam Integer page
    ) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<MyMissionDTO> missionPage = userMissionService.getInProgressMissions(userId, pageable);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, missionPage.getContent());
    }

}
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
}
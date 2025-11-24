package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.service.UserMissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserMissionService userMissionService;

    @PostMapping("/{userId}/missions/{missionId}/challenge")
    public ResponseEntity<ApiResponse<Long>> challengeMission(
            @PathVariable Long userId,
            @PathVariable Long missionId
    ) {
        UserMission newUserMission = userMissionService.challengeMission(userId, missionId);

        return ResponseEntity.ok(ApiResponse.onSuccess(SuccessCode._CREATED, newUserMission.getId()));
    }
}

package com.example.umc9th2.domain.user.controller;

import com.example.umc9th2.domain.user.dto.req.UserReqDTO;
import com.example.umc9th2.domain.user.dto.res.UserResDTO;
import com.example.umc9th2.domain.user.service.UserService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    public ApiResponse<UserResDTO.JoinDTO> signup(
            @RequestBody UserReqDTO.JoinDTO request
    ) {
        UserResDTO.JoinDTO result = userService.signup(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }
//로그아웃
    @PostMapping("/logout")
    @Operation(summary = "로그아웃", description = "사용자 로그아웃을 처리합니다.")
    public ApiResponse<String> logout() {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, "로그아웃되었습니다.");
    }
}


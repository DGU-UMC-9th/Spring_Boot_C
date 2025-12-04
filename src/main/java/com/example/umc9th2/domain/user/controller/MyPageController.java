package com.example.umc9th2.domain.user.controller;

import com.example.umc9th2.domain.user.dto.MyPageDTO;
import com.example.umc9th2.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;

    @GetMapping
    public MyPageDTO getMyPage(@RequestParam Long userId) {
        return userService.getMyPage(userId);
    }
}
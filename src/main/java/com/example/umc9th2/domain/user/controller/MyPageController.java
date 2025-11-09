package com.example.umc9th2.domain.user.controller;

import com.example.umc9th2.domain.user.dto.MyPageDTO;
import com.example.umc9th2.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mypage")
public class MyPageController {

    private final UserService userService;
    public MyPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public MyPageDTO getMyPage(@RequestParam Long userId) {
        return userService.getMyPage(userId);
    }
}
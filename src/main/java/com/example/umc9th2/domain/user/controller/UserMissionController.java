package com.example.umc9th2.domain.user.controller;

import com.example.umc9th2.domain.user.dto.MyMissionDTO;
import com.example.umc9th2.domain.user.service.UserMissionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-missions")
public class UserMissionController {

    private final UserMissionService userMissionService;
    public UserMissionController(UserMissionService userMissionService) {
        this.userMissionService = userMissionService;
    }

    @GetMapping
    public List<MyMissionDTO> getMyMissions(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return userMissionService.getMyMissions(userId, pageable);
    }
}
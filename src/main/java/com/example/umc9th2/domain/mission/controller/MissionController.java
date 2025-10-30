package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.dto.HomeMission;
import com.example.umc9th2.domain.mission.service.MissionService;
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

    @GetMapping("/home")
    public List<HomeMission> getHomeMissions(
            @RequestParam Long userId,
            @RequestParam Long regionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return missionService.getHomeMissions(userId, regionId, pageable);
    }
}
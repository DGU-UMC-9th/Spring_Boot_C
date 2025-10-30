package com.example.umc9th2.domain.mission.service;


import com.example.umc9th2.domain.mission.dto.HomeMission;
import com.example.umc9th2.domain.mission.repository.MissionRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    private final MissionRepository missionRepository;
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<HomeMission> getHomeMissions(Long userId, Long regionId, Pageable pageable) {
        return missionRepository.findHomeMissions(userId, regionId, pageable);
    }
}

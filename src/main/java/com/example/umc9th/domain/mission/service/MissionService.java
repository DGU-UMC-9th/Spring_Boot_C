package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.AvailableMissionDto;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;

    public List<AvailableMissionDto> getAvailableMissionList(
            Long memberId, Long locationId, Long lastMissionId) {

        if (lastMissionId == null) {
            lastMissionId = Long.MAX_VALUE;
        }

        return missionRepository.findAvailableMissions(
                memberId,
                locationId,
                lastMissionId
        );
    }
}
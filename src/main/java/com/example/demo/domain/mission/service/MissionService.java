package com.example.demo.domain.mission.service;

import com.example.demo.domain.mission.dto.MissionResponseDTO;
import com.example.demo.domain.mission.entity.Mission;
import com.example.demo.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionResponseDTO.MissionPreviewDTO> getMissionsByLocation(Long locationId) {

        List<Mission> missionList = missionRepository.findAllByLocationId(locationId);

        return missionList.stream()
                .map(mission -> MissionResponseDTO.MissionPreviewDTO.builder()
                        .storeName(mission.getStore().getName()) //
                        .conditional(mission.getConditional())
                        .point(mission.getPoint())
                        .build())
                .collect(Collectors.toList());
    }
}

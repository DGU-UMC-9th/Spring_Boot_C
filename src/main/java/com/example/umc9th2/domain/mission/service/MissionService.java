package com.example.umc9th2.domain.mission.service;


import com.example.umc9th2.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th2.domain.mission.dto.res.HomeMissionResDTO;
import com.example.umc9th2.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.Mission;
import com.example.umc9th2.domain.mission.repository.MissionRepository;
import com.example.umc9th2.domain.mission.converter.MissionConverter;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.repository.StoreRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public MissionService(MissionRepository missionRepository, StoreRepository storeRepository) {
        this.missionRepository = missionRepository;
        this.storeRepository = storeRepository;
    }

    public List<HomeMissionResDTO> getHomeMissions(Long userId, Long regionId, Pageable pageable) {
        return missionRepository.findHomeMissions(userId, regionId, pageable);
    }

    @Transactional
    public MissionResDTO.CreateMission createMission(MissionReqDTO.CreateMission request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission mission = MissionConverter.toMission(request);
        mission.setStore(store);

        Mission savedMission = missionRepository.save(mission);

        return MissionConverter.toCreateMissionDTO(savedMission);
    }
}
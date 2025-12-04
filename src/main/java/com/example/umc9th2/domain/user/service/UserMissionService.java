package com.example.umc9th2.domain.user.service;

import com.example.umc9th2.domain.user.dto.MyMissionDTO;
import com.example.umc9th2.domain.user.dto.res.UserMissionResDTO;
import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.user.entity.mapping.UserMission;
import com.example.umc9th2.domain.user.repository.UserMissionRepository;
import com.example.umc9th2.domain.user.repository.UserRepository;
import com.example.umc9th2.domain.user.converter.UserMissionConverter;
import com.example.umc9th2.domain.mission.entity.Mission;
import com.example.umc9th2.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserMissionService {
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    public List<MyMissionDTO> getMyMissions(Long userId, Pageable pageable) {
        return userMissionRepository.findMyMissions(userId, pageable);
    }
//미션 도전

    @Transactional
    public UserMissionResDTO.ChallengeMission challengeMission(Long missionId) {
        User user = userRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));


        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found")); //조회 검증


        boolean alreadyChallenged = userMissionRepository.findAll().stream()
                .anyMatch(um -> um.getUser().getUserId().equals(user.getUserId())
                        && um.getMission().getMissionId().equals(missionId)); //도전중인거 제외하기

        if (alreadyChallenged) {
            throw new IllegalArgumentException("Already challenged this mission");
        }
        UserMission userMission = new UserMission();

        userMission.setUser(user);
        userMission.setMission(mission);
        userMission.setStatus(false);
        UserMission savedUserMission = userMissionRepository.save(userMission);
        return UserMissionConverter.toChallengeMissionDTO(savedUserMission);
    }
}

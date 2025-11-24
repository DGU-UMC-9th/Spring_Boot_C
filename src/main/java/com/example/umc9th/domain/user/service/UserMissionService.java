package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.user.converter.UserMissionConverter;
import com.example.umc9th.domain.user.dto.UserMissionResDto;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.repository.UserMissionRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionService {

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;

    // 미션페이지 유저 미션 조회
    public Page<UserMissionResDto> getMissionsByStatus(Long userId, boolean isDone, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userMissionRepository.findMissionsByUserIdAndStatus(userId, isDone, pageable);
    }

    @Transactional
    public UserMission challengeMission(Long userId, Long missionId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.USER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        // UserMission 중복 도전 확인
        if (userMissionRepository.existsByUserAndMissionAndIsDone(user, mission, false)) {
            throw new GeneralException(GeneralErrorCode.BAD_REQUEST);
        }

        UserMission userMission = UserMissionConverter.toUserMission(user, mission);

        return userMissionRepository.save(userMission);
    }
}

package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.user.dto.UserMissionResDto;
import com.example.umc9th.domain.user.repository.UserMissionRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionService {

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    // 미션페이지 유저 미션 조회
    public Page<UserMissionResDto> getMissionsByStatus(Long userId, boolean isDone, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userMissionRepository.findMissionsByUserIdAndStatus(userId, isDone, pageable);
    }
}

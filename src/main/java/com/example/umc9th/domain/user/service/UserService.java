package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.user.dto.UserHomeResDto;
import com.example.umc9th.domain.user.dto.UserHomeTopResDto;
import com.example.umc9th.domain.user.dto.UserInfoResDto;
import com.example.umc9th.domain.user.dto.UserMissionResDto;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserMissionRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    // 마이페이지 유저 정보 조회
    public UserInfoResDto getUserInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 유저를 찾을 수 없습니다. ID: " + userId));

        return UserInfoResDto.builder()
                .id(user.getId())
                .nickName(user.getNickname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNum())
                .totalPoint(user.getTotalPoint())
                .build();
    }

    // 홈 페이지 정보 조회
    public UserHomeResDto getHomeInfo(Long userId, int page, int size) {
        UserHomeTopResDto topInfo = userRepository.findHomeTopInfo(userId);
        Page<UserMissionResDto> missions = userMissionRepository.findOngoingMissions(
                userId, PageRequest.of(page, size));
        return new UserHomeResDto(topInfo, missions);
    }
}

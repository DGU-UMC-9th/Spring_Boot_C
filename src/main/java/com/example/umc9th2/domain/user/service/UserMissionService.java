package com.example.umc9th2.domain.user.service;

import com.example.umc9th2.domain.user.dto.MyMissionDTO;
import com.example.umc9th2.domain.user.repository.UserMissionRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMissionService {
    private final UserMissionRepository userMissionRepository;
    public UserMissionService(UserMissionRepository userMissionRepository) {
        this.userMissionRepository = userMissionRepository;
    }
    public List<MyMissionDTO> getMyMissions(Long userId, Pageable pageable) {
        return userMissionRepository.findMyMissions(userId, pageable);
    }
}

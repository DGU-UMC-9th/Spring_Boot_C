package com.example.umc9th2.domain.user.service;

import com.example.umc9th2.domain.user.dto.MyPageDTO;
import com.example.umc9th2.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public MyPageDTO getMyPage(Long userId) {
        return userRepository.findMyPageSummary(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
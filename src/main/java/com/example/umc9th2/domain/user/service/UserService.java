package com.example.umc9th2.domain.user.service;

import com.example.umc9th2.domain.user.dto.MyPageDTO;
import com.example.umc9th2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public MyPageDTO getMyPage(Long userId) {
        return userRepository.findMyPageSummary(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
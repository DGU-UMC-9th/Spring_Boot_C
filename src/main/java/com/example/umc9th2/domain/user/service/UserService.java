package com.example.umc9th2.domain.user.service;

import com.example.umc9th2.domain.user.dto.MyPageDTO;
import com.example.umc9th2.domain.user.dto.req.UserReqDTO;
import com.example.umc9th2.domain.user.dto.res.UserResDTO;
import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.user.exception.code.UserErrorCode;
import com.example.umc9th2.domain.user.repository.UserRepository;
import com.example.umc9th2.domain.user.converter.UserConverter;
import com.example.umc9th2.global.apiPayload.exception.GeneralException;
import com.example.umc9th2.global.auth.CustomUserDetails;
import com.example.umc9th2.global.auth.JwtUtil;
import com.example.umc9th2.global.auth.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional(readOnly = true)
    public MyPageDTO getMyPage(Long userId) {
        return userRepository.findMyPageSummary(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    // 회원가입
    @Transactional
    public UserResDTO.JoinDTO signup(UserReqDTO.JoinDTO dto) {
        String passwordHash = passwordEncoder.encode(dto.password());
        User user = UserConverter.toUser(dto, passwordHash, Role.ROLE_USER);
        User savedUser = userRepository.save(user);
        return new UserResDTO.JoinDTO(
                savedUser.getUserId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

    // 로그인
    @Transactional(readOnly = true)
    public UserResDTO.LoginDTO login(UserReqDTO.LoginDTO dto) {
        // User 조회
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new GeneralException(UserErrorCode.USER_NOT_FOUND));

        // 비밀번호 검증
        if (!passwordEncoder.matches(dto.password(), user.getPasswordHash())) {
            throw new GeneralException(UserErrorCode.INVALID_PASSWORD);
        }
        CustomUserDetails userDetails = new CustomUserDetails(user);
        String accessToken = jwtUtil.createAccessToken(userDetails);
        return UserConverter.toLoginDTO(user, accessToken);
    }
}
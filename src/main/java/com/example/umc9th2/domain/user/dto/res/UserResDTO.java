package com.example.umc9th2.domain.user.dto.res;

public class UserResDTO {

    public record JoinDTO(
            Long userId,
            String username,
            String email
    ) {}

    // 로그인
    public record LoginDTO(
            Long userId,
            String accessToken
    ) {}
}


package com.example.umc9th2.domain.user.dto.res;

public class UserResDTO {

    public record JoinDTO(
            Long userId,
            String username,
            String email
    ) {}
}


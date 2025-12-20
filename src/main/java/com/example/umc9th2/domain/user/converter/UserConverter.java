package com.example.umc9th2.domain.user.converter;

import com.example.umc9th2.domain.user.dto.req.UserReqDTO;
import com.example.umc9th2.domain.user.dto.res.UserResDTO;
import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.global.auth.enums.Role;

public class UserConverter {

    public static User toUser(
            UserReqDTO.JoinDTO dto,
            String passwordHash,
            Role role
    ) {
        return User.builder()
                .username(dto.name())
                .email(dto.email())
                .passwordHash(passwordHash)
                .role(role)
                .birthday(dto.birth())
                .address(dto.address() + " " + dto.specAddress()) // address와 specAddress 합치기
                .gender(dto.gender())
                .totalPoints(0)
                .build();
    }

    public static UserResDTO.LoginDTO toLoginDTO(User user, String accessToken) {
        return new UserResDTO.LoginDTO(
                user.getUserId(),
                accessToken
        );
    }
}


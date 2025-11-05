package com.example.umc9th.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserInfoResDto {

    Long id;

    String nickName;

    String email;

    String phoneNumber;

    int totalPoint;
}

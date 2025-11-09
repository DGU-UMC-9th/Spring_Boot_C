package com.example.demo.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberResponseDTO {

    // 마이페이지 조회 결과를 담을 DTO
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyPageDTO {
        // 화면의 'nickname012'는 Entity의 name 필드라고 가정
        private String nickname;
        private String email;
        private String phoneNumber;
    }
}
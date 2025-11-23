package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResDto {

    // 미션 도전 성공 시 응답 DTO
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionResultDto {
        private Long memberMissionId;    // 생성된 도전 기록의 ID
        private LocalDateTime createdAt; // 도전 시작 시간
    }
}

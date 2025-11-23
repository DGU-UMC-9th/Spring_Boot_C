package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import java.time.LocalDateTime;

public class MemberMissionConverter {

    // 도전 시작 (DTO -> Entity)
    public static MemberMission toEntity() {
        return MemberMission.builder()
                .isComplete(false) // 초기 상태는 '진행 중'
                .build();
    }

    // 도전 성공 응답 (Entity -> DTO)
    public static MemberMissionResDto.CreateMemberMissionResultDto toCreateResultDto(MemberMission memberMission) {
        return MemberMissionResDto.CreateMemberMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
package com.example.demo.domain.mission.converter;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.entity.mapping.MemberMission;
import com.example.demo.domain.mission.dto.res.MissionResDTO;
import com.example.demo.domain.mission.entity.Mission;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .isComplete(false) // 초기엔 성공 안함
                .build();
    }

    public static MissionResDTO.MissionJoinResultDto toJoinResultDto(MemberMission memberMission) {
        return MissionResDTO.MissionJoinResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

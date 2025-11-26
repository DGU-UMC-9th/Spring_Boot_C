package com.example.demo.domain.mission.service.command;

import com.example.demo.domain.member.entity.mapping.MemberMission;
import com.example.demo.domain.mission.dto.req.MissionReqDTO;

public interface MissionCommandService {
    public MemberMission joinMission(MissionReqDTO.MissionJoinDto request);
}

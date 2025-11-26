package com.example.demo.domain.mission.service.command;


import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.entity.mapping.MemberMission;
import com.example.demo.domain.member.exception.MemberException;
import com.example.demo.domain.member.exception.code.MemberErrorCode;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.domain.mission.converter.MemberMissionConverter;
import com.example.demo.domain.mission.dto.req.MissionReqDTO;
import com.example.demo.domain.mission.entity.Mission;
import com.example.demo.domain.mission.exception.MissionException;
import com.example.demo.domain.mission.exception.code.MissionErrorCode;
import com.example.demo.domain.mission.repository.MemberMissionRepository;
import com.example.demo.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission joinMission(MissionReqDTO.MissionJoinDto request) {

        // 1. 회원 존재 확인
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 2. 미션 존재 확인
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        // 3. 이미 도전 중인지 확인 -> 추가해야함

        // 4. 매핑 엔티티 생성 및 저장
        MemberMission memberMission = MemberMissionConverter.toEntity(member, mission);

        return memberMissionRepository.save(memberMission);
    }

}

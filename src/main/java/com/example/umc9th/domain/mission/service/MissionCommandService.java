package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.converter.MemberMissionConverter;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public MemberMission challengeMission(Long missionId) {

        // 회원 조회
        Member member = memberRepository.findById(1L) // 1번 멤버
                .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));

        // 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("미션을 찾을 수 없습니다."));

        // 이미 도전 중인지 확인 (중복 방지)
        if (memberMissionRepository.existsByMemberIdAndMissionId(member.getId(), mission.getId())) {
            // 이미 도전 중이면 에러 처리
            throw new RuntimeException("이미 도전 중인 미션입니다.");
        }

        // 매핑 엔티티 생성
        MemberMission memberMission = MemberMissionConverter.toEntity();

        // 연관관계 설정
        memberMission.setMember(member);
        memberMission.setMission(mission);

        // 저장
        return memberMissionRepository.save(memberMission);
    }
}
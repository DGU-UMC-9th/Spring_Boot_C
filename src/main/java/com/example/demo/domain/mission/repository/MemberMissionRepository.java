package com.example.demo.domain.mission.repository;

import com.example.demo.domain.member.entity.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}

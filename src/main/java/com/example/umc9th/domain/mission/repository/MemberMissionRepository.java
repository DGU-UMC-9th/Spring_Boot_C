package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MyMissionDto;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "    mm.member_mission_id AS memberMissionId, " +
                    "    mm.is_complete AS isComplete, " +
                    "    m.title AS title, " +
                    "    m.description AS description, " +
                    "    s.name AS storeName " +
                    "FROM " +
                    "    member_mission mm " +
                    "JOIN " +
                    "    mission m ON mm.mission_id = m.mission_id " +
                    "JOIN " +
                    "    store s ON m.store_id = s.store_id " +
                    "WHERE " +
                    "    mm.member_id = :memberId " +
                    "    AND mm.member_mission_id < :lastId " +
                    "ORDER BY " +
                    "    mm.member_mission_id DESC " +
                    "LIMIT 10"
    )
    List<MyMissionDto> findMyMissionsByCursor(
            @Param("memberId") Long memberId,
            @Param("lastId") Long lastId
    );
}
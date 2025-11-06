package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.AvailableMissionDto;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "    m.mission_id AS missionId, " +
                    "    m.title AS title, " +
                    "    m.description AS description, " +
                    "    s.name AS storeName " +
                    "FROM " +
                    "    mission m " +
                    "JOIN " +
                    "    store s ON m.store_id = s.store_id " +
                    "JOIN " +
                    "    location l ON s.location_id = l.location_id " +
                    "LEFT JOIN " +
                    "    member_mission mm ON m.mission_id = mm.mission_id " +
                    "                     AND mm.member_id = :memberId " +
                    "WHERE " +
                    "    l.location_id = :locationId " +
                    "    AND mm.mission_id IS NULL " +
                    "    AND m.mission_id < :lastMissionId " +
                    "ORDER BY " +
                    "    m.mission_id DESC " +
                    "LIMIT 10"
    )

    List<AvailableMissionDto> findAvailableMissions(
            @Param("memberId") Long memberId,
            @Param("locationId") Long locationId,
            @Param("lastMissionId") Long lastMissionId
    );
}
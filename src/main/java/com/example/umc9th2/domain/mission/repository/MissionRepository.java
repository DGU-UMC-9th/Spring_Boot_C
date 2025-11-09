package com.example.umc9th2.domain.mission.repository;


import com.example.umc9th2.domain.mission.dto.HomeMission;
import com.example.umc9th2.domain.mission.entity.Mission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
select new com.example.umc9th2.domain.mission.dto.HomeMission(
    m.missionId,
    m.title,
    m.description,
    m.rewardPoints,
    s.storeName,
    coalesce(um.status, 'AVAILABLE')
)
from Mission m
join m.store s
join s.region r
left join UserMission um 
   on um.mission.missionId = m.missionId and um.user.userId = :userId
where r.regionId = :regionId and m.isActive = true
order by m.missionId desc
""")
    List<HomeMission> findHomeMissions(
            @Param("userId") Long userId,
            @Param("regionId") Long regionId,
            Pageable pageable
    );
}
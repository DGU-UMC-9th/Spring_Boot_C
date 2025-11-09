package com.example.umc9th2.domain.user.repository;


import com.example.umc9th2.domain.user.dto.MyMissionDTO;
import com.example.umc9th2.domain.user.entity.mapping.UserMission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    @Query("""
select new com.example.umc9th2.domain.user.dto.MyMissionDTO(
    m.missionId,
    m.title,
    m.description,
    m.rewardPoints,
    um.status,
    um.clearedAt,
    s.storeName,
    rg.regionName
)
from UserMission um
join um.mission m
join m.store s
join s.region rg
where um.user.userId = :userId
order by um.status asc, um.clearedAt desc
""")
    List<MyMissionDTO> findMyMissions(@Param("userId") Long userId, Pageable pageable);
}

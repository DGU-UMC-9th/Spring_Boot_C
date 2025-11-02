package com.example.umc9th.domain.user.repository;


import com.example.umc9th.domain.user.dto.UserMissionResDto;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("""
        SELECT new com.example.umc9th.domain.user.dto.UserMissionResDto(
            um.id,
            m.point,
            r.name,
            m.content,
            um.isDone
        )
        FROM UserMission um
        JOIN um.mission m
        JOIN m.restaurant r
        WHERE um.user.id = :userId
          AND um.isDone = :isDone
        ORDER BY um.id ASC
        """)
    Page<UserMissionResDto> findMissionsByUserIdAndStatus(
            @Param("userId") Long userId,
            @Param("isDone") boolean isDone,
            Pageable pageable);


    @Query("""
    SELECT new com.example.umc9th.domain.user.dto.UserMissionResDto(
        um.id,
        m.point,
        r.name,
        m.content,
        um.isDone
    )
    FROM UserMission um
    JOIN um.mission m
    JOIN m.restaurant r
    WHERE um.user.id = :userId
      AND um.isDone = FALSE
    ORDER BY um.id ASC
    """)
    Page<UserMissionResDto> findOngoingMissions(
            @Param("userId") Long userId,
            Pageable pageable);

}

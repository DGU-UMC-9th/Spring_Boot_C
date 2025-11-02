package com.example.demo.domain.mission.repository;

import com.example.demo.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("SELECT m FROM Mission m JOIN FETCH m.store s WHERE s.location.id = :locationId")
    List<Mission> findAllByLocationId(@Param("locationId") Long locationId);

}
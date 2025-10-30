package com.example.umc9th2.domain.user.entity.mapping;

import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.mission.entity.Mission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_mission")
@Getter
@Setter
@NoArgsConstructor
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMissionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Column(length = 30)
    private String status = "IN_PROGRESS";

    private LocalDateTime clearedAt;
}

package com.example.demo.domain.member.entity.mapping;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.mission.entity.Mission;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="member_mission")
public class MemberMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="is_complete")
    private boolean isComplete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;

}
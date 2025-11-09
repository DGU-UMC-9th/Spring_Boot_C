package com.example.demo.domain.mission.entity;

import com.example.demo.domain.store.entity.Store;
import com.example.demo.domain.member.entity.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="deadline")
    private LocalDate deadline;


    @Column(name="conditional")
    private String conditional;

    @Column(name="point")
    private Integer point;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @OneToMany(mappedBy = "mission")
    private List<MemberMission>  memberMissions;


}

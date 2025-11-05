package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.restaurants.entity.Restaurant;
import com.example.umc9th.domain.terms.enums.TermsEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deadline", nullable = false)
    private Date deadline;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "point", nullable = false)
    private float point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;
}

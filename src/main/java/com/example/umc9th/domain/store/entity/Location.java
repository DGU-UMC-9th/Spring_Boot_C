package com.example.umc9th.domain.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Location(1) : Store(N) 관계
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Store> storeList = new ArrayList<>();
}
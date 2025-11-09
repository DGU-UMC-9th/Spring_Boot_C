package com.example.demo.domain.store.entity;

import com.example.demo.domain.location.entity.Location;
import com.example.demo.domain.mission.entity.Mission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="name")
    private String name;

    @Column(name="manager_number")
    private String managerNumber;

    @Column(name="detail_address")
    private  String detailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id")
    private Location location;

    @OneToMany(mappedBy = "store")
    private List<Mission> missions;

}

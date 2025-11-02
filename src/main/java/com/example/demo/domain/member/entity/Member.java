package com.example.demo.domain.member.entity;
import com.example.demo.domain.member.entity.mapping.MemberFood;
import com.example.demo.domain.member.entity.mapping.MemberMission;
import com.example.demo.domain.member.enums.Address;
import com.example.demo.domain.member.enums.Gender;
import com.example.demo.domain.member.enums.SocialType;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Column(name="birth")
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(name="address")
    private Address address;

    @Column(name="detail_address")
    private String detailAddress;

    @Column(name="social_uid")
    private String socialUid;

    @Enumerated(EnumType.STRING)
    @Column(name="social_type")
    private SocialType socialType;

    @Column(name="point")
    private Integer point;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "member")
    private List<MemberFood> memberfoods;


    @OneToMany(mappedBy = "member")
    private List<MemberMission> missions;

}

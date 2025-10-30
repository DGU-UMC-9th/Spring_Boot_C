package com.example.umc9th.domain.user.entity;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length=3, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.UNKNOWN;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_num", nullable = false)
    private String phoneNum;

    @Column(name = "phone_verified", nullable = false)
    private String phoneVerified;

    @Column(name = "total_point")
    private int totalPoint;

    @Column(name = "status")
    private boolean status;

    @Column(name = "inactive_date")
    private Date inactiveDate;

}

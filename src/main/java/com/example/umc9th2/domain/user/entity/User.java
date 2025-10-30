package com.example.umc9th2.domain.user.entity;

import com.example.umc9th2.domain.user.entity.mapping.UserMission;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.global.BaseEntity;
import com.example.umc9th2.domain.user.entity.mapping.UserTerm;
import com.example.umc9th2.domain.user.entity.mapping.UserFood;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false)
    private Integer totalPoints = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 10)
    private Gender gender;

    @Column(nullable = true)
    private LocalDate birthday;

    @Column(nullable = true, length = 255)
    private String address;

    // 연관 관계
    @OneToMany(mappedBy = "user")
    private List<UserFood> userFoods;

    @OneToMany(mappedBy = "user")
    private List<UserTerm> userTerms;

    @OneToMany(mappedBy = "user")
    private List<UserMission> userMissions;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public enum Gender {
        남, 여
    }
}

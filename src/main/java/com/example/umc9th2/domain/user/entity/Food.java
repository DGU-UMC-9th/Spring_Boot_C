package com.example.umc9th2.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private FoodName foodName;

    public enum FoodName {
        한식, 중식, 일식, 양식, 분식, 치킨, 도시락, 아시안, 디저트, 패스트푸드
    }
}

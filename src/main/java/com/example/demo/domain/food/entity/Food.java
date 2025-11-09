package com.example.demo.domain.food.entity;

import com.example.demo.domain.member.entity.mapping.MemberFood;
import com.example.demo.domain.member.enums.FoodName;
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
@Table(name="food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private FoodName name;

    @OneToMany(mappedBy = "food")
    private List<MemberFood> memberFoods;

}
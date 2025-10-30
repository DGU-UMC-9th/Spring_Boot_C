package com.example.umc9th2.domain.user.entity.mapping;
import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.user.entity.Food;

import com.example.umc9th2.domain.user.entity.Term;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_food")
@Getter
@Setter
@NoArgsConstructor
public class UserFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberFoodId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}

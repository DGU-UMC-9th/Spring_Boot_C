package com.example.umc9th.domain.terms.entity;

import com.example.umc9th.domain.terms.enums.TermsEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "terms")
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private TermsEnum name;

    @Column(name = "content", nullable = false)
    private String content;
}

package com.example.umc9th2.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_term")
@Getter
@Setter
@NoArgsConstructor
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TermName name;

    public enum TermName {
        필수_서비스_이용약관,
        필수_개인정보_수집,
        선택_위치정보,
        선택_마케팅_수신
    }
}

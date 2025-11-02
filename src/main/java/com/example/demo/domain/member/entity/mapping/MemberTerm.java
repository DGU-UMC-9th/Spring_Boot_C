package com.example.demo.domain.member.entity.mapping;

import com.example.demo.domain.member.enums.TermName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//수정 필요
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="member_Term")
public class MemberTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    @Enumerated(EnumType.STRING)
    private TermName name;
}
package com.example.umc9th.domain.review.entity;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    // Member(1) : Review(N) 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // Store(1) : Review(N) 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    // Review(1) : Reply(N) 관계
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Reply> replyList = new ArrayList<>();
}
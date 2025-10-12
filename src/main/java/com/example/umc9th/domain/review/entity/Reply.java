package com.example.umc9th.domain.review.entity;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "reply") // 테이블 이름 명시
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id") // DB 컬럼명은 'reply_id'
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false) // ERD의 'content' 컬럼, 필수값으로 설정
    private String content;

    // Review(1) : Reply(N) 관계
    // ERD에 따르면 Reply는 Review에 속해 있습니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    // Member(1) : Reply(N) 관계
    // ERD에 따르면 Reply는 Member가 작성합니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
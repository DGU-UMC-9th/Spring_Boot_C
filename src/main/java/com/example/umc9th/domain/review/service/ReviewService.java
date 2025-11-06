package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository; // Review repository
    private final MemberRepository memberRepository; // Member repository
    private final StoreRepository storeRepository;   // Store repository

    // 생성자
    public ReviewService(ReviewRepository reviewRepository,
                         MemberRepository memberRepository,
                         StoreRepository storeRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.storeRepository = storeRepository;
    }

    // 리뷰 생성 메서드
    public Review createReview(Long memberId, Long storeId, String content, Integer rating) {

        // 외래키로 사용할 엔티티 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("멤버를 찾을 수 없습니다."));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("가게를 찾을 수 없습니다."));

        // Review 엔티티의 @Builder(생성 도구)를 사용해 리뷰 객체 생성
        Review newReview = Review.builder()
                .member(member) // memberId가 아닌 그냥 member 객체를 넣음 -> JPA 알아서 id를 뽑아서 sql에 넣어줌
                .store(store)
                .content(content)
                .rating(rating)
                .build();

        // save()를 이용해 DB에 저장(INSERT)
        return reviewRepository.save(newReview);
    }
}
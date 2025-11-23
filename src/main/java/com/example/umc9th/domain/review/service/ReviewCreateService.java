package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewReqDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCreateService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Review createReview(Long storeId, ReviewReqDto.JoinDto request) {

        // DTO -> Entity 변환
        Review review = ReviewConverter.toEntity(request);

        // 1번 유저 조회
        Member member = memberRepository.findById(1L) // ID가 1인 멤버 고정
                .orElseThrow(() -> new RuntimeException("멤버를 찾을 수 없습니다."));

        // 가게 조회
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("가게를 찾을 수 없습니다."));

        // 연관관계 매핑
        review.setMember(member);
        review.setStore(store);

        // 저장
        return reviewRepository.save(review);
    }
}
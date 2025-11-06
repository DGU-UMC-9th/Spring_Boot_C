package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.store.entity.QLocation;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository; // Review repository
    private final MemberRepository memberRepository; // Member repository
    private final StoreRepository storeRepository;   // Store repository

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

    // 리뷰 조회
    public List<Review> searchReview(String query, String type) {

        // // Q클래스 정의
        QReview review = QReview.review;
        QLocation location = QLocation.location;

        // // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // BooleanBuilder 사용

        // 동적 쿼리: 검색 조건
        if (type.equals("location")) {
            // 리뷰가 속한 가게(store)의 위치(location) 이름(name)을 검색
            builder.and(location.name.contains(query));
        }

        if (type.equals("rating")) {
            // 리뷰의 별점(rating)이 query 값(숫자) 이상(goe)인 경우
            builder.and(review.rating.goe(Float.parseFloat(query)));
        }

        if (type.equals("both")) {
            // & 기준 변환
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            // 동적 쿼리
            builder.and(location.name.contains(firstQuery));
            builder.and(review.rating.goe(Float.parseFloat(secondQuery)));
        }

        // Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.showReview(builder);

        // 리턴
        return reviewList;
    }

    // 미션
    public List<Review> getMyReviews(Long memberId, String query, String type) {

        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();


        // 파라미터로 받은 memberId를 가진 member의 리뷰
        builder.and(review.member.id.eq(memberId));

        if (type != null && !type.isEmpty()) {
            if (type.equals("store")) {
                builder.and(review.store.id.eq(Long.parseLong(query)));
            }

            if (type.equals("rating")) {
                builder.and(review.rating.goe(Float.parseFloat(query)));
            }

            if (type.equals("both")) {
                String[] queries = query.split("&");
                String firstQuery = queries[0];
                String secondQuery = queries[1];
                builder.and(review.store.id.eq(Long.parseLong(firstQuery)));
                builder.and(review.rating.goe(Float.parseFloat(secondQuery)));
            }
        }

        return reviewRepository.showReview(builder);
    }
}
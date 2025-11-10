package com.example.demo.domain.review.repository;


import com.example.demo.domain.review.entity.QReview;
import com.example.demo.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo.domain.member.entity.QMember.member;
import static com.example.demo.domain.store.entity.QStore.store;

@Repository
@RequiredArgsConstructor
public class ReciewQueryDslImpl implements ReviewQueryDsl {
    private final JPAQueryFactory queryFactory;

    QReview review =QReview.review;

    @Override
    public List<Review> searchReview(Predicate predicate) {
        return queryFactory.selectFrom(review)
                .leftJoin(review.member, member).fetchJoin()
                .leftJoin(review.store,store).fetchJoin()
                .where(predicate)
                .fetch();
    }
}

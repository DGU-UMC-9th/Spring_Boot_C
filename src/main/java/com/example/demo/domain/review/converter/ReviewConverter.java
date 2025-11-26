package com.example.demo.domain.review.converter;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.review.dto.req.ReviewReqDTO;
import com.example.demo.domain.review.dto.res.ReviewResDTO;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.store.entity.Store;
import com.example.demo.domain.test.dto.res.TestResDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResDTO.ErrorResult toExceptionDTO(
            String Reviewting
    ){
        return ReviewResDTO.ErrorResult.builder()
                .ReviewString(Reviewting)
                .build();
    }


    // 1. DTO -> Entity 변환 (DB 저장용)
    public static Review toEntity(ReviewReqDTO.ReviewRegisterDTO request, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .star(request.getScore())
                .content(request.getContent())
                .build();
    }

    // 2. Entity -> DTO 변환 (응답용)
    public static ReviewResDTO.ReviewCreateResultDTO toCreateResultDTO(Review review) {
        return ReviewResDTO.ReviewCreateResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }



}
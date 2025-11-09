package com.example.demo.domain.review.dto;

import com.example.demo.domain.review.entity.Review; // (이 DTO는 static inner class가 아니라고 가정)
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {

    private String nickname;
    private Float star;
    private String content;
    private LocalDateTime createdAt;


    public static ReviewResponseDTO from(Review review) {
        return ReviewResponseDTO.builder()
                .nickname(review.getMember().getName()) //
                .star(review.getStar())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
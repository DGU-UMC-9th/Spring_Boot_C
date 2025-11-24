package com.example.demo.domain.review.dto.res;
import com.example.demo.domain.review.entity.Review;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;




public class ReviewResDTO {


    @Getter
    @Builder
    public static class ReviewResponse {

        private String nickname;
        private Float star;
        private String content;
        private LocalDateTime createdAt;

        public static ReviewResponse from(Review review) {
            return ReviewResponse.builder()
                    .nickname(review.getMember().getName()) //
                    .star(review.getStar())
                    .content(review.getContent())
                    .createdAt(review.getCreatedAt())
                    .build();
        }
    }


    @Builder
    @Getter
    public static class ErrorResult{
        private String ReviewString;
    }



}

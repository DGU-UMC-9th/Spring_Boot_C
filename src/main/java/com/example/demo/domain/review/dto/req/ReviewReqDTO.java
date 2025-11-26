package com.example.demo.domain.review.dto.req;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

public class ReviewReqDTO {

    @Getter
    public static class ReviewRegisterDTO {
        @NotNull
        private Long memberId; // 리뷰 작성자 ID
        @NotNull
        private Long storeId;  // 가게 ID
        @NotNull
        private Float score;   // 별점
        @NotNull
        private String content; // 리뷰 내용
    }
}


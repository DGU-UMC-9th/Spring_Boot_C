package com.example.umc9th.domain.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewReqDto {
    @Getter
    public static class JoinDto {
        @NotBlank
        private String content;
        @NotNull
        private Float score;
    }
}

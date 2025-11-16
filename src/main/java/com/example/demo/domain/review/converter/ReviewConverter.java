package com.example.demo.domain.review.converter;

import com.example.demo.domain.review.dto.res.ReviewResDTO;
import com.example.demo.domain.test.dto.res.TestResDTO;

public class ReviewConverter {

    public static ReviewResDTO.ErrorResult toExceptionDTO(
            String Reviewting
    ){
        return ReviewResDTO.ErrorResult.builder()
                .ReviewString(Reviewting)
                .build();
    }
}
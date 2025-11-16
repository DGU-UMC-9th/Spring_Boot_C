package com.example.demo.domain.test.converter;

import com.example.demo.domain.test.dto.res.TestResDTO;


public class TestConverter {
    public static TestResDTO.Testing toTestingDTO(
            String testing
    ) {
        return TestResDTO.Testing.builder()
                .testString(testing)
                .build();
    }

    public static TestResDTO.Exception toExceptionDTO(
            String testing
            ){
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }


}
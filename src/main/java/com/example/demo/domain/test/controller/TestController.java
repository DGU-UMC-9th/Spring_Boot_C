package com.example.demo.domain.test.controller;

import com.example.demo.domain.test.converter.TestConverter;
import com.example.demo.domain.test.dto.res.TestResDTO;
import com.example.demo.domain.test.exception.TestException;
import com.example.demo.domain.test.service.query.TestQueryService;
import com.example.demo.global.apiPayload.ApiResponse;
import com.example.demo.global.apiPayload.code.GeneralErrorCode;
import com.example.demo.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping("/test")
    public ApiResponse<TestResDTO.Testing> test() throws Exception {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        throw new TestException(GeneralErrorCode.INTERNAL_SERVER_ERROR);
        //  return ApiResponse.onSuccess(code,
        //        TestConverter.toTestingDTO("This is a test!"));
        // }

    }
    @GetMapping("/exception")
    public ApiResponse<TestResDTO.Exception> exception(
            @RequestParam Long flag
    ) {
        testQueryService.checkFlag(flag);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, TestConverter.toExceptionDTO("this isss test!"));
    }
}
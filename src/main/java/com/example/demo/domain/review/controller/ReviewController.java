package com.example.demo.domain.review.controller;


import com.example.demo.domain.review.converter.ReviewConverter;
import com.example.demo.domain.review.dto.req.ReviewReqDTO;
import com.example.demo.domain.review.dto.res.ReviewResDTO;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.review.service.command.ReviewCommandService;
import com.example.demo.domain.review.service.query.ReviewQueryService;
import com.example.demo.global.apiPayload.ApiResponse;
import com.example.demo.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    @GetMapping("/my")
    public ApiResponse<List<ReviewResDTO.ReviewResponse>> getMyReviews(
            // @AuthenticationPrincipal User user, 로그인 기능 구현시 추가
            @RequestParam(required = false) Long storeId,
            @RequestParam(required = false) Double starRating
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        // Long currentUserId = user.getId(); 실제 유저 ID
        Long tempUserId = 1L; // 임시 유저 ID
        List<ReviewResDTO.ReviewResponse> reviewList = reviewQueryService.getMyReviews(tempUserId, storeId, starRating);
        //List<Review> reviews = reviewService.getMyReviews(tempUserId, storeId, starRating);
        return ApiResponse.onSuccess(code,reviewList);
    }
    @GetMapping("/exception")
    public ApiResponse<ReviewResDTO.ErrorResult> exception(
            @RequestParam Long flag
    ) {
        reviewQueryService.checkFlag(flag);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        ReviewResDTO.ErrorResult exceptionDto = ReviewConverter.toExceptionDTO("This is Review test");
        return ApiResponse.onSuccess(code,exceptionDto);
    }


    @PostMapping("/post")
    public ApiResponse<ReviewResDTO.ReviewCreateResultDTO> createReview(
            @RequestBody ReviewReqDTO.ReviewRegisterDTO request) {

        // 서비스 실행
        Review review = reviewCommandService.createReview(request);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        // 결과 반환
        return ApiResponse.onSuccess(code,ReviewConverter.toCreateResultDTO(review));
    }

}


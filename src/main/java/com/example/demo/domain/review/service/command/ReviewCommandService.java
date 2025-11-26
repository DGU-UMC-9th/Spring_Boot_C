package com.example.demo.domain.review.service.command;

import com.example.demo.domain.review.dto.req.ReviewReqDTO;
import com.example.demo.domain.review.entity.Review;

public interface ReviewCommandService {

    public Review createReview(ReviewReqDTO.ReviewRegisterDTO request);

}

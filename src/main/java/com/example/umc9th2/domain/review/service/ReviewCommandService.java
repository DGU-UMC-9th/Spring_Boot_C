package com.example.umc9th2.domain.review.service;

import com.example.umc9th2.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th2.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.repository.ReviewRepository;
import com.example.umc9th2.domain.review.converter.ReviewConverter;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.repository.StoreRepository;
import com.example.umc9th2.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.user.repository.UserRepository;
import com.example.umc9th2.domain.user.exception.code.UserErrorCode;
import com.example.umc9th2.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public ReviewResDTO.CreateReview createReview(
            ReviewReqDTO.CreateReview request,
            Long userId
    ) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(UserErrorCode.USER_NOT_FOUND));

        Store store = storeRepository.findById(request.storeId())
                .orElseThrow(() -> new GeneralException(StoreErrorCode.NOT_FOUND));

        Review review = ReviewConverter.toEntity(request, user, store);

        reviewRepository.save(review);

        return ReviewConverter.toCreateReviewResultDto(review);
    }
}


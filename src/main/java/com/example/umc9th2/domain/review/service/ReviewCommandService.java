package com.example.umc9th2.domain.review.service;

import com.example.umc9th2.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th2.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.repository.ReviewRepository;
import com.example.umc9th2.domain.review.converter.ReviewConverter;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.repository.StoreRepository;
import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public ReviewCommandService(ReviewRepository reviewRepository,
                                StoreRepository storeRepository,
                                UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }

  
    @Transactional
    public ReviewResDTO.CreateReview createReview(ReviewReqDTO.CreateReview request) {
        //하드 코딩한 유저 
        User user = userRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));// Store 조회

       
        Review review = ReviewConverter.toReview(request); // DTO->Entity
        review.setUser(user);    
        review.setStore(store);   
        Review savedReview = reviewRepository.save(review); // DB저장
        return ReviewConverter.toCreateReviewDTO(savedReview); // Entity->DTO
    }
}


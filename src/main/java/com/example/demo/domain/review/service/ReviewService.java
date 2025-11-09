package com.example.demo.domain.review.service;

import com.example.demo.domain.review.dto.ReviewResponseDTO;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponseDTO> getReviewsByStore(Long storeId) {

        List<Review> reviewList = reviewRepository.findAllByStoreIdWithMember(storeId);

        return reviewList.stream()
                .map(ReviewResponseDTO::from)
                .collect(Collectors.toList());
    }
}

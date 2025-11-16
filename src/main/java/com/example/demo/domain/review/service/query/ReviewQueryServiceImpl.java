package com.example.demo.domain.review.service.query;

import com.example.demo.domain.review.dto.res.ReviewResDTO;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.review.exception.ReviewException;
import com.example.demo.domain.review.exception.code.ReviewErrorCode;
import com.example.demo.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.example.demo.domain.review.entity.QReview.review;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    @Override
    public void checkFlag(Long flag) {
        if(flag==1){
            throw new ReviewException(ReviewErrorCode.Review_EXCEPTION);
        }
    }

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewResDTO.ReviewResponse> getMyReviews(Long userId, Long storeId, Double starRating) {

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.member.id.eq(userId));

        List<Review> entityList = reviewRepository.searchReview(builder);

        List<ReviewResDTO.ReviewResponse> ListDTO = entityList.stream()
                .map(ReviewResDTO.ReviewResponse::from) // 👈 기계 호출!
                .toList();
        return ListDTO;
    }
}

package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewDetailDto;
import com.example.umc9th.domain.review.dto.ReviewSearchResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.entity.mapping.ReviewImage;

import java.util.List;

public class ReviewConverter {
    /** Review 리스트 -> ReviewSearchResDto 변환 */
    public static ReviewSearchResDto toReviewSearchResDto(List<Review> reviews) {

        if (reviews.isEmpty()) {
            return new ReviewSearchResDto(0, null, List.of());
        }

        Review first = reviews.get(0);

        Long restaurantId = first.getRestaurant().getId();
        String restaurantName = first.getRestaurant().getName();

        List<ReviewDetailDto> reviewDtos = reviews.stream()
                .map(ReviewConverter::toReviewDetailDto)
                .toList();

        return new ReviewSearchResDto(
                restaurantId,
                restaurantName,
                reviewDtos
        );
    }

    /** Review → ReviewDetailDto */
    public static ReviewDetailDto toReviewDetailDto(Review review) {
        return new ReviewDetailDto(
                review.getUser().getNickname(),
                review.getRating(),
                review.getContent(),
                review.getCreateAt().toLocalDate(), // BaseEntity createdAt 타입에 따라 조정 필요
                review.getReviewImages().stream()      // 🔥 변경된 부분
                        .map(ReviewImage::getImgUrl)
                        .toList()
        );
    }

    /** Review 이미지 URL 리스트 변환 */
    private static List<String> extractImageUrls(List<ReviewImage> images) {
        return images.stream()
                .map(ReviewImage::getImgUrl)
                .toList();
    }
}

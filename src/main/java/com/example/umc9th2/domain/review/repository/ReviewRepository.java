package com.example.umc9th2.domain.review.repository;

import com.example.umc9th2.domain.review.entity.Review;
import org.springframework.data.jpa.repository.*;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {
//내가 작성한 리뷰 목록
    Page<Review> findByUser_UserId(Long userId, Pageable pageable);

}

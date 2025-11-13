package com.example.umc9th2.domain.review.repository;

import com.example.umc9th2.domain.review.dto.ReviewDTO;
import com.example.umc9th2.domain.review.entity.Review;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {
}

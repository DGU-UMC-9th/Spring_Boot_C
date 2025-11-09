package com.example.umc9th2.domain.review.repository;

import com.example.umc9th2.domain.review.dto.ReviewDTO;
import com.example.umc9th2.domain.review.entity.Review;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
@Query("""
select new com.example.umc9th2.domain.review.dto.ReviewDTO(
    r.reviewId,
    u.username,
    r.rating,
    r.content
)
from Review r
join r.user u
where r.store.storeId = :storeId
order by r.reviewId desc
""")
Page<ReviewDTO> findReviewsByMissionId(
        @Param("storeId") Long storeId,
        Pageable pageable
    );
}

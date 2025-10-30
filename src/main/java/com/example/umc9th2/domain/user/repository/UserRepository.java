package com.example.umc9th2.domain.user.repository;


import com.example.umc9th2.domain.user.dto.MyPageDTO;
import com.example.umc9th2.domain.user.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
    select new com.example.umc9th2.domain.user.dto.MyPageDTO(
        u.userId,
        u.username,
        u.email,
        u.totalPoints,
        count(r.reviewId)
    )
    from User u
    left join Review r on r.user.userId = u.userId
    where u.userId = :userId
    group by u.userId, u.username, u.email, u.totalPoints
""")
    Optional<MyPageDTO> findMyPageSummary(@Param("userId") Long userId);
}
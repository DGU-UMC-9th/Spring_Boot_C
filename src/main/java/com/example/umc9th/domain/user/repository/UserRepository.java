package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.dto.UserHomeTopResDto;
import com.example.umc9th.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findById(Long id);

 @Query("""
    SELECT new com.example.umc9th.domain.user.dto.UserHomeTopResDto(
        u.address,
        u.totalPoint,
        COUNT(um)
    )
    FROM User u
    LEFT JOIN UserMission um ON um.user.id = u.id AND um.isDone = TRUE
    WHERE u.id = :userId
    GROUP BY u.address, u.totalPoint
    """)
 UserHomeTopResDto findHomeTopInfo(@Param("userId") Long userId);
}

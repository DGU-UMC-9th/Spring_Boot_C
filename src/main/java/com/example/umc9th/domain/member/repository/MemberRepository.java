package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.dto.MyPageDto; // 1. 방금 만든 인터페이스 임포트
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<MyPageDto> findMyPageInfoById(Long id);

}
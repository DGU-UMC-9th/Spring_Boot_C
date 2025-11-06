package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.member.dto.MyPageDto; // 인터페이스 DTO 임포트
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //"읽기 전용" 설정
public class MemberService {

    private final MemberRepository memberRepository;

    // 마이페이지 정보 조회
    public MyPageDto getMyPageInfo(Long memberId) {

        Optional<MyPageDto> dtoBox = memberRepository.findMyPageInfoById(memberId);

        // 비어있으면 에러
        MyPageDto myPageDto = dtoBox.orElseThrow(
                () -> new RuntimeException("해당 멤버를 찾을 수 없습니다.")
        );

        // 내용물이 담긴 DTO 반환
        return myPageDto;
    }
}
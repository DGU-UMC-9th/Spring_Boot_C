package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MyMissionDto;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;


    public List<MyMissionDto> getMyMissionList(Long memberId, Long lastId) {

        // "첫 페이지" 조회를 위한 커서 값 처리
        // 'lastId'가 null (처음 페이지 요청)이면 가장 큰 값으로 설정
        if (lastId == null) {
            lastId = Long.MAX_VALUE;
        }

        return memberMissionRepository.findMyMissionsByCursor(memberId, lastId);
    }
}
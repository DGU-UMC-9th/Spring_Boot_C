package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserMission;

public class UserMissionConverter {

    public static UserMission toUserMission(User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .isDone(false)         // 도전 시점에는 아직 미완료 상태
                .managerNumber(0)      // 초기 매니저 번호는 0으로 설정
                .build();
    }
}
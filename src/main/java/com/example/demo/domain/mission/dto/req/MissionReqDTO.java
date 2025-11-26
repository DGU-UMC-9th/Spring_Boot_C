package com.example.demo.domain.mission.dto.req;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

public class MissionReqDTO {

    @Getter
    public static class MissionJoinDto {
        @NotNull
        private Long memberId;
        @NotNull
        private Long missionId;
    }
}

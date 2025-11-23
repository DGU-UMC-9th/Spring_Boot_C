package com.example.umc9th2.domain.mission.dto.req;
import lombok.Getter;
@Getter
public class MissionReqDTO {
    
    //미션 생성
    @Getter
    public static class CreateMission {
        private String title;         
        private String description;   
        private Integer rewardPoints;  
        private Long storeId;        
    }
}
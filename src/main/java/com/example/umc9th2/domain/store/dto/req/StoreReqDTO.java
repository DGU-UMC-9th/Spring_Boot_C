package com.example.umc9th2.domain.store.dto.req;

import lombok.Getter;

//생성
@Getter
public class StoreReqDTO {
   
    public static class CreateStore {
        private String storeName;  
        private String ownerPin;   
        private Long regionId;      
    }
}


package com.example.umc9th2.domain.store.dto.req;

import lombok.Getter;

//가계 생성 요청 DTO
@Getter
public class StoreReqDTO {

    public static class CreateStore {
        private String storeName;
        private String ownerPin;
        private Long regionId;
    }
}

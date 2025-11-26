package com.example.umc9th2.domain.store.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class StoreReqDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateStore {
        private String storeName;
        private String ownerPin;
        private Long regionId;
    }
}


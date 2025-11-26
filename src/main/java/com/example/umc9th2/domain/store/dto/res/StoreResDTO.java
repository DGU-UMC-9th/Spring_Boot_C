package com.example.umc9th2.domain.store.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreResDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateStore {
        private Long storeId;
        private String storeName;
        private String regionName;
    }
}


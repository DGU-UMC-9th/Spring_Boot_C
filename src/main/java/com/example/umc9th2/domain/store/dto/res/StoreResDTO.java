package com.example.umc9th2.domain.store.dto.res;

import lombok.Builder;
import lombok.Getter;

//가게 생성 응답
public class StoreResDTO {


    @Builder
    @Getter
    public static class CreateStore {
        private Long storeId;
        private String storeName;
        private String regionName;
    }
}

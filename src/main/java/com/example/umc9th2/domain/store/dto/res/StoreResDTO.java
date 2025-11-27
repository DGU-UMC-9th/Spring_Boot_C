package com.example.umc9th2.domain.store.dto.res;

public class StoreResDTO {
    
    public record CreateStore(
            Long storeId,
            String storeName,
            String regionName
    ) {}
}


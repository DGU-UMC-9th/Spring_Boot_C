package com.example.umc9th2.domain.store.dto.req;

//record 로 바꿈 

public record StoreReqDTO(
        String storeName,
        String ownerPin,
        Long regionId
) {}


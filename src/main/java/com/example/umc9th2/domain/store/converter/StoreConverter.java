package com.example.umc9th2.domain.store.converter;

import com.example.umc9th2.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th2.domain.store.dto.res.StoreResDTO;
import com.example.umc9th2.domain.store.entity.Store;

public class StoreConverter {
    public static Store toStore(StoreReqDTO request) {
        Store store = new Store();
        store.setStoreName(request.storeName());
        store.setOwnerPin(request.ownerPin());
        return store;
    }

    public static StoreResDTO.CreateStore toCreateStoreDTO(Store store) {
        return new StoreResDTO.CreateStore(
                store.getStoreId(),
                store.getStoreName(),
                store.getRegion() != null ? store.getRegion().getRegionName() : null
        );
    }
}


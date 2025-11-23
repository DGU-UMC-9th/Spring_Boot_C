package com.example.umc9th2.domain.store.converter;


import com.example.umc9th2.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th2.domain.store.dto.res.StoreResDTO;
import com.example.umc9th2.domain.store.entity.Store;

//Store 관련 데이터 변환

public class StoreConverter {
    //요청한 DTO 를 Store Entity로

    public static Store toStore(StoreReqDTO.CreateStore request) {
        Store store = new Store();
        store.setStoreName(request.getStoreName());
        store.setOwnerPin(request.getOwnerPin());
        return store;
    }
    
   // Store Entity를 응답 DTO로,,,
    public static StoreResDTO.CreateStore toCreateStoreDTO(Store store) {
        return StoreResDTO.CreateStore.builder()
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .regionName(store.getRegion() != null ? store.getRegion().getRegionName() : null)
                .build();
    }

}

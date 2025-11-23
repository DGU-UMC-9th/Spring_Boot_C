package com.example.umc9th2.domain.store.service;

import com.example.umc9th2.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th2.domain.store.dto.res.StoreResDTO;
import com.example.umc9th2.domain.store.entity.Region;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.repository.RegionRepository;
import com.example.umc9th2.domain.store.repository.StoreRepository;
import com.example.umc9th2.domain.store.converter.StoreConverter;
import org.springframework.stereotype.Service;


@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    public StoreService(StoreRepository storeRepository, RegionRepository regionRepository) {
        this.storeRepository = storeRepository;
        this.regionRepository = regionRepository;
    }

   
    public StoreResDTO.CreateStore createStore(StoreReqDTO.CreateStore request) {
       
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new IllegalArgumentException("Region not found")); //조회 

      
        Store store = StoreConverter.toStore(request);  // 2. DTO-> Entity

    
        store.setRegion(region);
        Store savedStore = storeRepository.save(store); // DB 저장ㄹ

        return StoreConverter.toCreateStoreDTO(savedStore); // Entity-> DTO
    }
}


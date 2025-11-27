package com.example.umc9th2.domain.store.service;

import com.example.umc9th2.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th2.domain.store.dto.res.StoreResDTO;
import com.example.umc9th2.domain.store.entity.Region;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.repository.RegionRepository;
import com.example.umc9th2.domain.store.repository.StoreRepository;
import com.example.umc9th2.domain.store.converter.StoreConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Transactional
    public Store createStore(StoreReqDTO request) {

        Region region = regionRepository.findById(request.regionId())
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));

        Store store = StoreConverter.toStore(request);
        store.setRegion(region);
        return storeRepository.save(store);
    }
}


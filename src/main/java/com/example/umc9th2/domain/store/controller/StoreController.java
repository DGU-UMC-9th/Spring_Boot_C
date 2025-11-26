package com.example.umc9th2.domain.store.controller;

import com.example.umc9th2.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.service.StoreService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createStore(@RequestBody StoreReqDTO.CreateStore request) {
        Store newStore = storeService.createStore(request);
        return ResponseEntity
                .status(GeneralSuccessCode.CREATED.getStatus())
                .body(ApiResponse.onSuccess(GeneralSuccessCode.CREATED, newStore.getStoreId()));
    }
}

package com.example.umc9th2.domain.store.controller;

import com.example.umc9th2.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th2.domain.store.dto.res.StoreResDTO;
import com.example.umc9th2.domain.store.service.StoreService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    //생성
    @PostMapping
    public ApiResponse<StoreResDTO.CreateStore> createStore(
            @RequestBody StoreReqDTO.CreateStore request
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        StoreResDTO.CreateStore result = storeService.createStore(request);//가게 생성
        return ApiResponse.onSuccess(code, result);
    }
}

package com.example.demo.domain.store.exception;

import com.example.demo.global.apiPayload.code.BaseErrorCode;

public class StoreException extends RuntimeException {
    public StoreException(BaseErrorCode code) {
        super((Throwable) code);
    }
}
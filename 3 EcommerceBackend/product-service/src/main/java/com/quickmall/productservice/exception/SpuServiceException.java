package com.quickmall.productservice.exception;

import lombok.Data;

@Data
public class SpuServiceException extends RuntimeException{

    private String statusCode;

    public SpuServiceException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}

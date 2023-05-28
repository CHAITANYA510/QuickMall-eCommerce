package com.quickmall.productservice.exception;

import lombok.Data;

@Data
public class BasicServiceException extends RuntimeException{

    private String statusCode;

    public BasicServiceException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}

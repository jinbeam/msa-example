package com.sample.api.exception;

import lombok.Getter;

/**
 * Created by jspark
 */
@Getter
public class ConflictException extends RuntimeException {
    private long id;
//    private ProductDetailDto.GetProductDetailReq req;
//
//    public ConflictException(long id) {
//        this.id = id;
//    }
//
//    public ConflictException(ProductDetailDto.GetProductDetailReq req) {
//        this.req = req;
//    }
}

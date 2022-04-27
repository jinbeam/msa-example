package com.sample.api.exception;

import lombok.Getter;

/**
 * Created by jslim
 */
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private long id;

    public ResourceNotFoundException(long id) {
        this.id = id;
    }
}

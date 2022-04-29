package com.menu.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by jslim
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    NOT_FOUND("???", "존재하지 않는 데이터입니다.", 404),
    USER_CONFLICT("???", "이미 등록된 아이디 입니다.", 400),
    INPUT_VALUE_INVALID("???", "입력값이 올바르지 않습니다.", 400);


    private final String code;
    private final String message;
    private final int status;

}

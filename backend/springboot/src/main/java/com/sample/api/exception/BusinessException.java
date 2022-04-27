/*
 * Copyright 2019-2019 by OSC .,
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of OSC . ("Confidential Information").
 */
package com.sample.api.exception;

/******************************************************************
 * <pre>
 * <b>Description  : 비지니스 익셉션</b>
 * <b>Project Name : sample-spring-boot-starter</b>
 * package  : com.ezpmp.core.exception
 * </pre>
 *
 * @author   :
 * @version  : 1.0
 * @since
 * Modification Information
 * <p>@  수정일      수정자              수정내용              </p>
 * <p>@ ---------   ---------   -------------------------------</p>
 * <p>@ 2019. 7. 22.  legion              최초생성                 </p>
 * @see
 * <b>Copyright (C) by OSC  All right reserved.</b>
 *******************************************************************/

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    private final String code;
    private final Object data;

    public BusinessException(String code) {
        super(code);
        this.code = code;
        this.data = null;
    }

    public BusinessException(String code, Object data) {
        super(code);
        this.code = code;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return this.code;
    }

    public String getCode() {
        return this.code;
    }

    public Object getData() {
        return this.data;
    }

}

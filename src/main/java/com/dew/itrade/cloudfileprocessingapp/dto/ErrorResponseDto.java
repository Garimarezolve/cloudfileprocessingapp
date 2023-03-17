package com.dew.itrade.cloudfileprocessingapp.dto;

import com.dew.itrade.cloudfileprocessingapp.constant.ApplicationConstant;

public class ErrorResponseDto <T> implements ResponseDto<T>{

    private Integer code = ApplicationConstant.HTTP_RESPONSE_ERROR_CODE;
    private T data;
    private String message;
    private Integer status = ApplicationConstant.ERROR_STATUS_CODE;
    private long timestamp;



    public ErrorResponseDto() {
    }

    public ErrorResponseDto(Integer errorCode, String errorMessage) {
        this.code = errorCode;
        this.message = errorMessage;
        this.timestamp = System.currentTimeMillis();
    }

    public ErrorResponseDto(Integer errorCode, String errorMessage, T data) {
        this.data = data;
        this.code = errorCode;
        this.message = errorMessage;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setCode(Integer code) {
        this.code=code;
    }

    @Override
    public void setData(T data) {
        this.data=data;
    }

    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public void setStatus(Integer status) {
        this.status=status;

    }

    @Override
    public void setTimeStamp(long currentTimeMillis) {
        this.timestamp=currentTimeMillis;
    }
}

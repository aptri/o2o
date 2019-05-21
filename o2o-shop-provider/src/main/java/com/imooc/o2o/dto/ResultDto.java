package com.imooc.o2o.dto;

import java.io.Serializable;

public class ResultDto<T> implements Serializable {

    private static final String SUCCESS="success";
    private static final String FAILURE="FAILURE";
    private String status;
    private String message;
    private String code;
    private String detail;
    private T result;

    public ResultDto() {
        this.status = SUCCESS;
    }

    public static <T>ResultDto<T> reject(String code, String message,T result) {
        ResultDto<T> resultDto=new ResultDto<>();
        resultDto.setStatus(FAILURE);
        resultDto.setMessage(message);
        resultDto.setCode(code);
        resultDto.setResult(result);
        return resultDto;
    }
    public static <T> ResultDto<T> reject(String code, String message) {
        return reject(code, message, (T) null);
    }

    public static <T> ResultDto<T> reject(String message) {
        return reject(null, message, (T) null);
    }

    public <T>ResultDto<T> success(){
        ResultDto<T> resultDto=new ResultDto<T>();
        resultDto.setStatus(SUCCESS);
        return resultDto;
    }
    public static <T> ResultDto<T> success(T result) {
        ResultDto<T> resultDTO = new ResultDto<T>();
        resultDTO.setStatus(SUCCESS);
        resultDTO.setResult(result);
        return resultDTO;
    }
    public boolean isFailure() {
        return !SUCCESS.equalsIgnoreCase(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

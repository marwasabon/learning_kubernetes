package com.zain.shortcode.util;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(content = JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    private Integer responseCode = ResponseCode.SUCCESS.getCode();
    private String responseMessage = ResponseCode.SUCCESS.getMessage();
    private String token;
    private T responseBean;

    public BaseResponse() {
    }

    public BaseResponse(T responseBean) {
        setResponseBean(responseBean);
    }

    public BaseResponse(Integer responseCode, T responseBean) {
        this.responseCode = responseCode;
        this.responseBean = responseBean;
    }

    public BaseResponse(Integer responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    /**
     * @return the responseCode
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the responseBean
     */
    public T getResponseBean() {
        return responseBean;
    }

    /**
     * @param responseBean the responseBean to set
     */
    public void setResponseBean(T responseBean) {
        this.responseBean = responseBean;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "BaseResponse [responseBean=" + responseBean + ", responseCode=" + responseCode + ", responseMessage="
                + responseMessage + "]";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

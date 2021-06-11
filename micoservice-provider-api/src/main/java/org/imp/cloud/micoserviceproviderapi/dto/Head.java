package org.imp.cloud.micoserviceproviderapi.dto;

import lombok.Data;

@Data
public class Head{
    private String code;
    private String message;
    private String signType = "MD5";
    private String md5Key;
    private String charset = "UTF-8";
    private String sign;
    private String timestamp;

    public Head(){

    }

    public Head(String code,String message){
        this.code = code;
        this.message = message;
    }
}

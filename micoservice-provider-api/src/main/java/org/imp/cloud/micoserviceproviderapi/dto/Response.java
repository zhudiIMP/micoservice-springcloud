package org.imp.cloud.micoserviceproviderapi.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -2233054917799697908L;
    private Head head;
    private T body;

    public Response(){

    }
    public static Response success(){
        Response response = new Response();
        response.setHead(new Head("00000","success"));
        response.setBody(new Object());
        return response;
    }

    public static<T> Response success(T body){
        Response response = new Response();
        response.setHead(new Head("00000","success"));
        response.setBody(body);
        return response;
    }
}

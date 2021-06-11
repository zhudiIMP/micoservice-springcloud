package org.imp.cloud.micoserviceproviderapi.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request<T> implements Serializable {
    private static final long serialVersionUID = -2233054917799697908L;
    private Head head;
    private T body;

    public Request(){

    }
}

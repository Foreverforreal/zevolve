package com.zhu.zevolve.common.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseEntity<T> implements Serializable {
    private int code;
    private String msg;
    private T data;


}

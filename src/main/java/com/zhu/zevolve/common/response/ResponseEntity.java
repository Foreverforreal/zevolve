package com.zhu.zevolve.common.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class ResponseEntity<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public static ResponseEntity build(){
        return new ResponseEntity();
    }
    public ResponseEntity ok(){
        this.setCode(HttpStatus.OK.value());
        return this;
    }
    public ResponseEntity fail(){
        this.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return this;
    }
    public ResponseEntity<T> addEntity(T data){
        this.setData(data);
        return this;
    }
}

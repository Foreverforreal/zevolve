package com.zhu.zevolve.common.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class ResponseEntity<T> implements Serializable {
    private int code;
    private String msg;
    private T body;

    private ResponseEntity(){ }

    public static ResponseEntity build(){
        return new ResponseEntity().msg("");
    }
    public ResponseEntity ok(){
        this.code = HttpStatus.OK.value();
        return this;
    }
    public ResponseEntity error(){
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        return this;
    }
    public ResponseEntity createSuccess(){
        this.code = HttpStatus.CREATED.value();
        return this;
    }
    public ResponseEntity notFound(){
        this.code = HttpStatus.NOT_FOUND.value();
        return this;
    }

    public ResponseEntity status(HttpStatus status){
        this.code = status.value();
        return this;
    }

    public ResponseEntity msg(String msg){
        this.msg = msg;
        return this;
    }

    public ResponseEntity<T> body(T data){
        this.body = data;
        return this;
    }
}

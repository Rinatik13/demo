package com.swimming.pool.demo.exception_handing;

public class NoSuchClientException extends RuntimeException {
    public NoSuchClientException (String message){
        super(message);
    }
}

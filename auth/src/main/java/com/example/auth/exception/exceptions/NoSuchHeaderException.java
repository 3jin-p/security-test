package com.example.auth.exception.exceptions;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 27.
 */
public class NoSuchHeaderException extends RuntimeException{

    public NoSuchHeaderException(String message){
        super(message);
    }

    public NoSuchHeaderException(){
        super("authentication.header.matchcase.notfound");
    }
}

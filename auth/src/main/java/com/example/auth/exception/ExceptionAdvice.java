package com.example.auth.exception;

import com.example.auth.util.MessageSourceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 15.
 */
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {
    private static final String CODE_SUFFIX = ".code";
    private static final String MSG_SUFFIX = ".msg";
    private final MessageSourceUtil messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ExceptionResponse defaultException(Exception e) {
        ExceptionResponse res = response(e.getMessage());
        if(res.isEmpty()) {
            res = response("unKnown");
        }
        return res;
    }

    private ExceptionResponse response(String type) {
        return ExceptionResponse.of(
                messageSource.getMessage(type + CODE_SUFFIX )
                , messageSource.getMessage(type + MSG_SUFFIX));
    }

}

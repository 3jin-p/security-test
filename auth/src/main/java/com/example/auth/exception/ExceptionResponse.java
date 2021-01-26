package com.example.auth.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 15.
 */
@Getter
public class ExceptionResponse {
    private String code;
    private String msg;

    protected static ExceptionResponse of(String code, String msg) {
        if(!StringUtils.hasText(code)) {
            return ExceptionResponse.emptyResponse();
        }
        return new ExceptionResponse(code, msg);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return !StringUtils.hasText(code);
    }

    private static ExceptionResponse emptyResponse() {
        return new ExceptionResponse();
    }

    private ExceptionResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ExceptionResponse() {}
}

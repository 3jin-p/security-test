package com.example.auth.web.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TestResponse<T> {

    public int httpStatus;
    public T data;

    public TestResponse(int httpStatus, T data) {
        this.httpStatus = httpStatus;
        this.data = data;
    }
}

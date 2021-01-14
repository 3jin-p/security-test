package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <b>
 *     AccessToken과 RefreshToken을 주고받을때 사용
 * </b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
@Getter
public class TokenResponse {

    private String token;

    public static TokenResponse of(String token){
        return new TokenResponse(token);
    }

    // Constructor
    private TokenResponse(String token) {
        this.token = token;
    }
}

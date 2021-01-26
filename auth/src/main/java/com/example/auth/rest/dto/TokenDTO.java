package com.example.auth.rest.dto;

import lombok.Getter;

/**
 * <b>
 *     AccessToken과 RefreshToken을 주고받을때 사용
 * </b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
@Getter
public class TokenDTO {

    private String token;

    public static TokenDTO of(String token){
        return new TokenDTO(token);
    }

    // Constructor
    private TokenDTO(String token) {
        this.token = token;
    }
}

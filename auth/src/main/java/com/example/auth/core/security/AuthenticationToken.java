package com.example.auth.core.security;

import java.util.Date;
import java.util.Optional;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 26.
 */
public interface AuthenticationToken<T> {
    String getSubject();
    boolean validate();
    T getData();
    Optional<String> createToken(String userId, String role, Date expiredDate);
}

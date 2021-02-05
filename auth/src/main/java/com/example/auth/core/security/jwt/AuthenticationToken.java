package com.example.auth.core.security.jwt;

import com.example.common.enums.UserRole;
import io.jsonwebtoken.Claims;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

/**
 * <b>
 * 추후 다양한 토큰이 생길시 확장을 위한 인터페이스
 * </b>
 *
 * @author sejinpark
 * @since 21. 1. 29.
 */
public interface AuthenticationToken<T> {

    /**
     * get Token Subject;
     * @return
     */
    String getSubject();

    /**
     * Validate Token
     * ex) expire date
     * @return
     */
    boolean validate();

    /**
     * Get Body Data From AuthenticationToken
     * @return
     */
     T getData();

    /**
     * Create Token Value
     * @return
     */
    Optional<String> createToken(String userId, Collection<UserRole> roles, Date expiredDate);
}

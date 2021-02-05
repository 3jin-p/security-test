package com.example.auth.core.security.jwt;

import com.example.common.enums.UserRole;

import java.util.Collection;
import java.util.Date;

/**
 * <b> Provides AuthenticationToken </b>
 *
 * @author sejinpark
 * @since 21. 1. 29.
 */
public interface TokenProvider<T> {

    T create(String id, Collection<UserRole> roles);

    T convert(String token);

}

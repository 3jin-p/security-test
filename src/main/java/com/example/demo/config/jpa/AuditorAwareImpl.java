package com.example.demo.config.jpa;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
//        return Optional.of(SecurityContextHolder.getContext().getAuthentication().getDetails())
        return Optional.empty();
    }
}
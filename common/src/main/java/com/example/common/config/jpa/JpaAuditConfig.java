package com.example.common.config.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditConfig {
//    @Bean
//    public AuditorAware<> auditorProvider() {
//        return new AuditorAwareImpl;
//    }
}
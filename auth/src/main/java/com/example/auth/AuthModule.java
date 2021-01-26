package com.example.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 26.
 */
@SpringBootApplication
@EntityScan("com.example.common.entity")
@EnableJpaRepositories("com.example.common.repo")
public class AuthModule {
    public static void main(String[] args) {
        SpringApplication.run(AuthModule.class, args);
    }
}

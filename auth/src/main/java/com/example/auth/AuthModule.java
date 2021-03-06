package com.example.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <b>Authentication Server Runner/b>
 *
 * @author sejinpark
 * @since 21. 1. 26.
 */
@SpringBootApplication
@ComponentScan({"com.example.common.config", "com.example.auth"})
@EntityScan("com.example.common.entity")
@EnableJpaRepositories("com.example.common.repo")
public class AuthModule {
    public static void main(String[] args) {
        SpringApplication.run(AuthModule.class, args);
    }
}

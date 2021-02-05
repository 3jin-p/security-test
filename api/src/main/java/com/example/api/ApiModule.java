package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 30.
 */
@SpringBootApplication
@ComponentScan({"com.example.common.config", "com.example.api"})
@EntityScan("com.example.common.entity")
@EnableJpaRepositories("com.example.common.repo")
public class ApiModule {
    public static void main(String[] args) {
        SpringApplication.run(ApiModule.class, args);
    }
}

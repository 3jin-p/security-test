package com.example.auth.config.etc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 25.
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }

    @Bean
    public ClassLoaderTemplateResolver thymeleafTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/"); // 모든 뷰 페이지는 /resources/templates/ 내부에서 검색한다.
        templateResolver.setSuffix(".html"); // 모든 뷰 페이지는 .html 이다.
        templateResolver.setTemplateMode("HTML"); // HTML 형식으로 읽는다.
        templateResolver.setCacheable(false); // 캐싱하지 않는다.
        return templateResolver;
    }
}
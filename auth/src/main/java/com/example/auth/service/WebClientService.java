package com.example.auth.service;

import com.example.auth.web.rest.dto.TestResponse;
import com.example.common.entity.Dummy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WebClientService {

    final String TEST_API_HOST_URL = "http://localhost:8080";

    public void callGetApi() {
        WebClient webClient = WebClient.create(TEST_API_HOST_URL);
        TestResponse response =  webClient.get()
                    .uri("/test/1")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .retrieve()
                    .bodyToMono(TestResponse.class)
                    .log()
                    .block();
        log.info("Test Get Api End -");
    }

    public void callPostApi() {
        try {
            WebClient webClient = WebClient.create(TEST_API_HOST_URL);
            TestResponse response =  webClient.post()
                    .uri("/test")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(new Dummy(1L, "더미데이터"))
                    .retrieve()
                    .bodyToMono(TestResponse.class)
                    .block();
        }catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Test Post Api End -");
    }
}

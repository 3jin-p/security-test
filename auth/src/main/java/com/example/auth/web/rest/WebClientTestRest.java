package com.example.auth.web.rest;

import com.example.auth.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebClientTestRest {

    private final WebClientService webClientService;

    @GetMapping("/test")
    public void callApiServerGet() {
       webClientService.callGetApi();
    }

    @PostMapping("/test")
    public void callApiServerPost() {
        webClientService.callPostApi();
    }
}

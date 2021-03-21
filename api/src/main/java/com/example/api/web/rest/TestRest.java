package com.example.api.web.rest;

import com.example.api.service.TestService;
import com.example.api.web.dto.TestResponse;
import com.example.common.entity.Dummy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/test")
@RequiredArgsConstructor
public class TestRest {

    private final TestService testService;

    @GetMapping("/{id}")
    public TestResponse<Dummy> getApiForTest(@PathVariable Long id) {
        return new TestResponse<>(HttpStatus.OK.value(), testService.testGet(id));
    }

    @DeleteMapping("/{id}")
    public TestResponse<Void> deleteApiForTest(@PathVariable Long id) {
        return new TestResponse(HttpStatus.OK.value(), Void.TYPE);
    }

    @PostMapping
    public TestResponse<Dummy> postApiForTest(@RequestBody Dummy dummy) {
        return new TestResponse<>(HttpStatus.OK.value(), testService.testPost(dummy));
    }
}

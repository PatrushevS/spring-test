package com.example.tests.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> getPong() {
        System.out.println(testService.someTest());
        return ResponseEntity.ok("pong");
    }
}

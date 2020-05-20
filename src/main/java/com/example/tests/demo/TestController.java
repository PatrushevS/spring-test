package com.example.tests.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    private NewHardService hardService;

    @GetMapping("/ping")
    public ResponseEntity<String> getPong() {
        System.out.println(testService.someTest());
        return ResponseEntity.ok("pong");
    }


    @GetMapping("/testController")
    public ResponseEntity<String> getTestController() {
        log.info("Start method getTestController");
        if(hardService.methodForController().equals("TestSuccess 1") || hardService.methodForController().equals("TestSuccess 2")){
            return ResponseEntity.ok("TestController with service was tested success!!");
        }else return ResponseEntity.ok("Test controller with service was failed");
    }

}

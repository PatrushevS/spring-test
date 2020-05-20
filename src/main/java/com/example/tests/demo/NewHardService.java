package com.example.tests.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NewHardService {

    private int param = 1;
    private String testMessage;

    public String methodForController(){
        log.info("Start methodForController");
        testMessage = methodAfterMethodForController(param);
        return testMessage;
    }

    private String methodAfterMethodForController(int parameter){
        log.info("Start methodAfterMethodForController");
        if (parameter > 0){
            return "TestSuccess 1";
        }else{
            return "TestSuccess 2";
        }
    }
}

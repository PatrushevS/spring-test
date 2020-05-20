package com.example.tests.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
class TestControllerGorinych3Test {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void getPong() throws Exception {
        System.out.println("Start Test getPong");
        String uri = "/ping";
        String requiredResponse = "pong";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
        .contentType(MediaType.ALL)).andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();
        System.out.println("actualResponse = " + actualResponse);
        assertEquals(requiredResponse, actualResponse);
    }

    @Test
    void getTestController() {
    }
}
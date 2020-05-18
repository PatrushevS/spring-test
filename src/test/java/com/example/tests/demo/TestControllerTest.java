package com.example.tests.demo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
class TestControllerTest {
    @Autowired
    private TestController controller;
    private MockMvc mockMvc;
    @Test
    @SneakyThrows
    void getPong() {
       MvcResult result = mockMvc.perform(get("/ping"))
               .andExpect(status().isOk())
               .andReturn();
       assertEquals("pong", result.getResponse().getContentAsString());
    }
}

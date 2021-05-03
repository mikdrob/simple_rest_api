package com.example.practice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class testController {

    @Autowired
    private PersonController controller;

    @Test
    void controllerBodyIsNotNull(){
        

    }
}

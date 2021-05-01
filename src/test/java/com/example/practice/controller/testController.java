package com.example.practice.controller;

import com.example.practice.api.dto.v1.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class testController {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void controllerBodyIsNotNull() {
        ResponseEntity<Person> entity = testRestTemplate.getForEntity("/api/v1/index", Person.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        //assertNotNull(rankResponse);

        //assertNotNull(rankResponse.getProfile().getName());
        //assertNotNull(rankResponse.getSoloRank());
        //assertNotNull(rankResponse.getCompetitiveRank());
        //assertNotNull(rankResponse.getMmr_estimate().getEstimate());
    }
}

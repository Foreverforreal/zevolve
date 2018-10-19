package com.zhu.zevolve.codegen.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
public class TableControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void list() {
        FluxExchangeResult<String> result =
                this.webClient.get()
                        .uri("/codegen/table/list")
                        .exchange()
                        .expectStatus().isOk()
                        .returnResult(String.class);
        System.out.println(result);
    }

    @Test
    public void gen() {
    }
}
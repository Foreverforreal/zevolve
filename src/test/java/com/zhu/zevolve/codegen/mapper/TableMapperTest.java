package com.zhu.zevolve.codegen.mapper;

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
public class TableMapperTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void getAllTable() throws Exception {

        FluxExchangeResult<String> result =
                this.webClient.get()
                        .uri("/codegen/table/list")
                        .exchange()
                        .expectStatus().isOk()
                        .returnResult(String.class);
        System.out.println(result);
    }
}


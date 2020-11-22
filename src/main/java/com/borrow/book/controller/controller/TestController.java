package com.borrow.book.controller.controller;


import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class TestController {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @GetMapping("/hello")
    public Mono<String> hello() {   //
        CreateIndexRequest request = new CreateIndexRequest("index_uuid");
        try {
            CreateIndexResponse clientResponse = restHighLevelClient.indices()
                    .create(request, RequestOptions.DEFAULT);
            System.out.println(clientResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Mono.just("Welcome bookflux!!");
    }


}

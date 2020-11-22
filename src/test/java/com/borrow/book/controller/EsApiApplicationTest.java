package com.borrow.book.controller;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApiApplicationTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Test
    public void TestCreateIndex() {
        CreateIndexRequest request = new CreateIndexRequest("index_test_uuid");
        try {
            CreateIndexResponse clientResponse = restHighLevelClient.indices()
                    .create(request, RequestOptions.DEFAULT);
            System.out.println(clientResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

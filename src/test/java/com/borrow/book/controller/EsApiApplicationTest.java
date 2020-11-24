package com.borrow.book.controller;

import com.alibaba.fastjson.JSON;
import com.borrow.book.domain.ResultBody;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
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
    public void TestCreateIndex() throws Exception {

          /*  IndexRequest request =new IndexRequest("idx");
            request.id("1");
            request.timeout(TimeValue.timeValueSeconds(1));
            request.timeout("1s");

            ResultBody body =new ResultBody();
            body.setCode("1");
            body.setMessage("返回成功11");
            request.source(JSON.toJSONString(body), XContentType.JSON);

            IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            System.out.println(index);*/


            //获取
             GetRequest getRequest=new GetRequest("idx","2");
             GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
             System.out.println(documentFields.getSourceAsString());
    }
}

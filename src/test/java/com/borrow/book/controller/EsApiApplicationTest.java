package com.borrow.book.controller;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApiApplicationTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private com.borrow.book.mapper.UserMapper userMapper;
    @Test
    public void TestCreateIndex() throws Exception {

          /*IndexRequest request =new IndexRequest("idx");
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

    @Test
    public void SqlTest() {
        //System.out.println(JSON.toJSONString(userMapper.QueryUserList()));

        List<String> languages = Arrays.asList("java","scala","python");
        languages.forEach(language ->{
            System.out.println(language);
        });
    }
    @Test
    public void LamdbaTest()
    {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        Double aDouble = cost.stream().map(x -> x + x * 1).reduce((sum, x) -> sum + x).get();
        System.out.println(aDouble);
    }
}

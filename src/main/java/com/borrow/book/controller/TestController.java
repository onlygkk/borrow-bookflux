package com.borrow.book.controller;


import com.borrow.book.domain.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class TestController {
    @GetMapping("/hello")
    public Flux<ResultBody> hello() {   //
        ResultBody resultBody=new ResultBody();
        resultBody.setCode("200");
        resultBody.setMessage("返回成功");
        return Flux.just(resultBody);
    }


}

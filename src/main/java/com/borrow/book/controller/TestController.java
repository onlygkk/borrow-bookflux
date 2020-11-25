package com.borrow.book.controller;


import com.borrow.book.domain.ResultBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@Controller
public class TestController {
    @GetMapping("/hello")
    public String hello() {   //
        return "index";
    }


}

package com.borrow.book.controller;


import com.borrow.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {   //
        return "index";
    }
}

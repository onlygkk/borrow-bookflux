package com.borrow.book;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.borrow.book.mapper")
public class BorrowBookFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(BorrowBookFluxApplication.class, args);
    }
}

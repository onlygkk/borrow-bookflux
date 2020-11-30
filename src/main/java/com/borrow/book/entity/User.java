package com.borrow.book.entity;

import lombok.Data;

@Data
public class User {

    public User(int id,String userName,String passWord,String realName){
        this.id=id;
        this.userName=userName;
        this.passWord=passWord;
        this.realName=realName;

    }
    private int id;

    private String userName;

    private String passWord;

    private String realName;


}

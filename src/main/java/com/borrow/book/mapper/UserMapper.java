package com.borrow.book.mapper;

import com.borrow.book.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> QueryUserList();
}

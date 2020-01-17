package com.teligen.mybatis.mapper;


import com.teligen.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends Mapper{


    List<User> findAll();
}

package com.xcr.test.mapper;

import com.xcr.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper extends Mapper{


    List<User> findAll();
}

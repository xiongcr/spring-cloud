package com.teligen.eureka_client.service.impl;

import com.teligen.eureka_client.service.UserService;

import com.teligen.mybatis.mapper.UserMapper;
import com.teligen.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}

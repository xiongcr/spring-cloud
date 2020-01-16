package com.teligen.service.impl;

import com.teligen.dao.UserMapper;
import com.teligen.model.User;
import com.teligen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserById(long id){
        //return userMapper.getUserById(id);
       return userMapper.selectByPrimaryKey(id);
    }
}

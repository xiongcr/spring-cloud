package com.teligen.hcs.service.impl;

import com.teligen.hcs.dao.UserMapper;
import com.teligen.hcs.model.User;
import com.teligen.hcs.service.UserService;
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

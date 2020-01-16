package com.teligen.service.impl;

import com.teligen.dao.UserMapper;
import com.teligen.model.User;
import com.teligen.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    UserMapper userMapper;

    @Transactional
    public User getUserById(long id){
        return userMapper.getUserById(id);
    }


}

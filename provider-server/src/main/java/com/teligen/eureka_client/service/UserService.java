package com.teligen.eureka_client.service;


import com.teligen.mybatis.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 获取所有部门信息
     * @return
     */
    List<User> findAll();
}

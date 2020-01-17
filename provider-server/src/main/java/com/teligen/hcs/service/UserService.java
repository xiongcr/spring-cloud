package com.teligen.hcs.service;
import com.xcr.test.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 获取所有部门信息
     * @return
     */
    List<User> findAll();
}

package com.teligen.dao;


import com.teligen.baseDao.BaseDao;
import com.teligen.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseDao<User> {
    User getUserById(long id);
}
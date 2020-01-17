package com.teligen.hcs.dao;


import com.teligen.hcs.baseDao.BaseDao;
import com.teligen.hcs.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseDao<User> {
    User getUserById(long id);
}
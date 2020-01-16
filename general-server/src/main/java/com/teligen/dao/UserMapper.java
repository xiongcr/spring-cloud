package com.teligen.dao;


import com.teligen.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserById(long id);
}
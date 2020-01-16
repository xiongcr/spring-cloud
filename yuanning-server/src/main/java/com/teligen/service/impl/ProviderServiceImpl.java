package com.teligen.service.impl;

import com.teligen.dao.ProviderDao;
import com.teligen.model.User;
import com.teligen.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    public ProviderDao providerDao;

    public User getUser(Long id){
        //java8新增特性 Optional
        Optional<User> user = providerDao.findById(id);
        return user.get();
    }

    @Transactional
    public void insertUser(User user){
        providerDao.save(user);
    }

    @Transactional
    public void updateLoginNumAndLastLoginTimeById(User user){
        providerDao.updateLogincountAndLastlogintimeById(user.getLogincount(),user.getLastlogintime(),user.getId());
    }

    @Transactional
    public void deleteUser(Long id){
        providerDao.deleteById(id);
    }

}

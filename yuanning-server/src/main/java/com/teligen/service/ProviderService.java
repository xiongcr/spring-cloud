package com.teligen.service;

import com.teligen.model.User;

public interface ProviderService {
    public User getUser(Long id);

    public void insertUser(User user);

    public void updateLoginNumAndLastLoginTimeById(User user);

    public void deleteUser(Long id);
}

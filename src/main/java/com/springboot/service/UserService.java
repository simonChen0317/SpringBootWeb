package com.springboot.service;

import com.springboot.domain.User;

public interface UserService {
    public boolean hasMatchUser(String userName, String password);
    public User findUserByUserName(String userName);
    public void loginSuccess(User user);
}

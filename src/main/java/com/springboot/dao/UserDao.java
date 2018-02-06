package com.springboot.dao;

import com.springboot.domain.User;

public interface UserDao {
    public User findUserByUserName(final String userName);
    public void updateLoginInfo(User user);
}

package com.jyj.portal.service;

import com.jyj.portal.model.User;

import java.util.List;

/**
 * Created by jiangyijie on 2017/9/28.
 */
public interface UserService {
    public boolean updateUser(User user);
    public User getUserById(int userId);
    public List<User> getAllUsers();
}

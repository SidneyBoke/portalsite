package com.jyj.portal.service;

import com.jyj.portal.model.User;

import java.util.List;

/**
 * Created by jiangyijie on 2017/9/28.
 */
public interface UserService {
    boolean updateUser(User user);
    User getUserById(int userId);
    List<User> getAllUsers();
}

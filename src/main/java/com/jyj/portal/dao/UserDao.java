package com.jyj.portal.dao;

import com.jyj.portal.model.User;

import java.util.List;

/**
 * Created by jiangyijie on 2017/9/28.
 */
public interface UserDao {
    void insert(User user);
    int update(User user);
    int delete(int userId);
    User queryById(int userId);
    List<User> queryAll();
}

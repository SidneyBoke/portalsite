package com.jyj.portal.service.impl;

import com.jyj.portal.dao.UserDao;
import com.jyj.portal.model.User;
import com.jyj.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiangyijie on 2017/9/28.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    public boolean updateUser(User user) {
        try {
            int count = userDao.update(user);
            if(count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public User getUserById(int userId) {
        return userDao.queryById(userId);
    }

    public List<User> getAllUsers() {
        return null;
    }
}

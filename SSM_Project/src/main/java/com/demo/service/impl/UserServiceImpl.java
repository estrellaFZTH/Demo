package com.demo.service.impl;

import com.demo.dao.UserMapper;
import com.demo.service.UserService;

import java.util.List;
import com.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Estrella
 * @create 2020-04-10 15:57
 */
@Service(value = "userService")  //此注解Service的名字为 userService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        System.out.println("业务层findUserById");
//        return null;
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public List<User> findUserAll() {
        System.out.println("业务层findUserAll");
        return userMapper.findUserAll();
    }

    @Override
    public void saveUser(User user) {
        //模拟出现异常
        System.out.println("业务层saveUser");
        //int i = 1/0;
        userMapper.saveUser(user);
    }

    @Override
    public void updateUserById(Integer id) {

    }

    @Override
    public List<User> findByIds(List<Integer> ids) {
        return null;
    }


}

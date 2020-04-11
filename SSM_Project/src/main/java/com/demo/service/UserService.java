package com.demo.service;

import org.apache.ibatis.annotations.Param;
import com.demo.vo.User;

import java.util.List;

/**
 * @author Estrella
 * @create 2020-04-10 15:54
 */
public interface UserService {

    User findUserById(Integer id);

    User findUserByUserName(String userName);

    void deleteUserById(Integer userId);

    void updateUserById(User user);

    List<User> findUserAll();

    void saveUser(User user);

    void updateUserById(Integer id);

    List<User> findByIds(@Param("ids") List<Integer> ids);
}

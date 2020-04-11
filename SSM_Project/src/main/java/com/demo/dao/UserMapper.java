package com.demo.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import com.demo.vo.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户dao接口
 * @author Estrella
 * @create 2020-04-10 15:33
 */
@Repository
public interface UserMapper {


    //注解式查找数据库
    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(Integer id);

    @Update("update user set username = #{userName}, password = #{passWord}, " +
            " createtime = #{createTime}, updatetime = #{updateTime} where id = #{id}")
    void updateUserById(User user);

    @Select("select * from user where username = #{userName}")
    User findUserByUserName(String userName);
    //User findUserByUserName(String userName);

    @Select("select * from user")
    List<User> findUserAll();

    //xml式查找数据库，需要配置一个xml文件，在xml文件里将方法与相应的sql语句对应起来。
    @Insert( "insert into user(username, password) " +
            "values (#{userName}, #{passWord})" )
    void saveUser(User user);

    void updateUserById(Integer id);

    //xml + mybatis-freemarker
    List<User> findByIds(@Param("ids") List<Integer> ids);
}

package com.demo.dao;

import com.demo.vo.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author Estrella
 * @create 2020-04-11 14:27
 */
@Repository
public interface AccountMapper {

    //可传带目标name的整个account进来，也可传单个name进来，两种方式均可。
    @Select("select * from account where name = #{name}")
    Account findAccountByName(String name);

    @Update("update account set name = #{name},money = #{money} where id = #{id}")
    void updateAccount(Account account);
}

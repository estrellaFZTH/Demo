package com.demo.service;

import com.demo.vo.Account;

/**
 * @author Estrella
 * @create 2020-04-11 14:28
 */
public interface AccountService {


    void updateAccountById(Account account);
    //可传带目标name的整个account进来，也可传单个name进来，两种方式均可。
    Account findAccountByName(String name);

    /**
     * 转账
     * @param sourceName  转出账户名称
     * @param tagName     转入账户名称
     * @param money
     */
    void transfer(String sourceName, String tagName, Float money);
}

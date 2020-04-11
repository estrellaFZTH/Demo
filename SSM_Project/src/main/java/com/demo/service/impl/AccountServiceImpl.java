package com.demo.service.impl;

import com.demo.dao.AccountMapper;
import com.demo.service.AccountService;
import com.demo.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户类业务层
 * 事务控制应该都是在业务层
 * @author Estrella
 * @create 2020-04-11 14:28
 */
@Service(value = "accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
//也可配置 @Transactional (propagation = Propagation.SUPPORTS, readOnly = true) //只读型事务配置
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public void updateAccountById(Account account) {
        System.out.println("updateAccountById...");
        accountMapper.updateAccount(account);
    }

    @Override
    public Account findAccountByName(String name) {
        System.out.println("findAccountByName...");
        return accountMapper.findAccountByName(name);
    }

    //需要的是读写型事务配置
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void transfer(String sourceName, String tagName, Float money) {
        System.out.println("transfer....");
        //2.1.根据名称查询转出账户
        Account source = accountMapper.findAccountByName(sourceName);
        //2.2.根据名称查询转入账户
        Account target = accountMapper.findAccountByName(tagName);
        //2.3.转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4.转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5.更新转出账户
        accountMapper.updateAccount(source);
        //模拟转账过程中出现的异常
        int i = 1/0;
        //2.6.更新转入账户
        accountMapper.updateAccount(target);

    }

}

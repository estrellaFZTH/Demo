package test;

import com.demo.service.AccountService;
import com.demo.service.UserService;
import com.demo.vo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.vo.User;

/**
 * @author Estrella
 * @create 2020-04-10 16:19
 */
public class TestSpring {

    @Test
    public void test1(){
        //加载spring的配置文件
        ApplicationContext ac = 
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        UserService userService = (UserService) ac.getBean("userService");
        //调用方法
        //User user = new User();
        //user.setUserName("AAaa");
        //userService.saveUser(user);

        //System.out.println(userService.findUserById(1));

        //userService.deleteUserById(2);

        User user = userService.findUserByUserName("aaa");
        System.out.println(user);
        user.setPassWord("1111");
        userService.updateUserById(user);


    }

    @Test
    public void test2(){
        //加载spring的配置文件
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService accountService = (AccountService) ac.getBean("accountService");
        //调用方法
        //System.out.println(accountService.findAccountByName("aa"));
        //

        //Account account = accountService.findAccountByName("aa");
        //account.setMoney(2300f);
        //System.out.println(accountService.findAccountByName(account));
        //accountService.updateAccountById(account);

        accountService.transfer("aa","bb",100f);
    }
}

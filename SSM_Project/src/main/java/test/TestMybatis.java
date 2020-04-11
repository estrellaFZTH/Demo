package test;

import com.demo.dao.UserMapper;
import com.demo.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Estrella
 * @create 2020-04-10 17:30
 */
public class TestMybatis {

    @Test
    public void test1() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 加载SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        UserMapper usermapper = session.getMapper(UserMapper.class);
        //调用方法
        System.out.println("TestMybatis: findUserById" + usermapper.findUserById(1));
        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void test2() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 加载SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        UserMapper usermapper = session.getMapper(UserMapper.class);
        //调用方法
        User user = new User();
        user.setUserName("小红");
        user.setPassWord("123456");
        //util.date 转换成 sql.date
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        String time = df.format(new Date());
       // user.setCreateTime(time);
       // user.setUpdateTime(time);
        usermapper.saveUser(user);
        System.out.println("TestMybatis: insertUser");
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }

    @Test()
    public void test3(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        System.out.println(userMapper.findUserByUserName("ccc"));
//        User user = new User("ccc","cc");
//        userMapper.saveUser(user);
        //System.out.println(userMapper.findByIds(Arrays.asList(1,2,3)));
    }
}

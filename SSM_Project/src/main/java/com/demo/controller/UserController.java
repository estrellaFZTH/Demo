package com.demo.controller;

import com.demo.exception.SysException;
import com.demo.service.UserService;
import com.demo.vo.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 用户web层控制器
 * @author Estrella
 * @create 2020-04-10 16:08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUserById")
    public String findUserById(Model model){
        System.out.println("表现层findUserById方法");
        //调用业务层service方法
        User userById = userService.findUserById(1);
        model.addAttribute("userById", userById);
        return "user";
    }

    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        System.out.println("表现层findUserAll方法");
        //调用业务层service方法
        List<User> userAll = userService.findUserAll();
        model.addAttribute("userAll", userAll);
        return "user";
    }

    @RequestMapping("/saveUser")
    public void saveUser(User user,
             HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层saveUser方法");
        System.out.println(user);
        userService.saveUser(user);
        //重定向
        response.sendRedirect(request.getContextPath()+"/user/findUserAll");
        return;
    }

    /**
     * 模拟异步请求与响应，需要导入pom依赖文件
     */
    @RequestMapping("/testAjax")
    //这里（修饰方法名的）的ResponseBody注解表示自动把user对象转换成json字符串并返回前台
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了");
        //客户端发送的ajax的请求，传的json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUserName("还好");
        user.setPassWord("222");
        //做响应
        return user;
    }

    /**
     * 文件上传之SpringMVC方式上传,需要导入pom依赖文件
     * @return
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传...");
        //使用fileupload组件完成文件上传
        //上传的位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断一下该路径是否存在
        File file = new File(realPath);
        if(!file.exists()){  //文件夹不存在
            //创建该文件夹
            file.mkdirs();
        }

        //获取到上次文件的名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置为唯一值 利用UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid+"_"+fileName;
        //完成文件上传
        upload.transferTo(new File(realPath, fileName));

        return "success";
    }

    /**
     * 文件上传之跨服务器方式上传，需要导入pom依赖文件
     * @return
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传...");
        //定义上传文件服务器路径
        String realPath = "http://localhost:8081/uploads/";

        //获取到上次文件的名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置为唯一值 利用UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid+"_"+fileName;

        //完成文件上传：跨服务器上传
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(realPath + fileName);//realPath + "/" + fileName
        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("testException方法执行了");

        try {
            //模拟异常
            int a = 1 / 0;
        } catch (Exception e) {
            //在控制台打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息：捕获异常
            throw new SysException("查询所有用户出现错误了");
        }

        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor方法执行了");
        return "successInterceptor";
    }
}

package com.demo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author Estrella
 * @create 2020-04-10 15:32
 */
public class User implements Serializable{
    //类的serialVersionUID的默认值完全依赖于Java编译器的实现，对于同一个类，用不同的Java编译器编译，
    // 有可能会导致不同的serialVersionUID，也有可能相同。为了提高serialVersionUID的独立性和确定性，
    // 强烈建议在一个可序列化类中显示的定义serialVersionUID，为它赋予明确的值。
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String userName;
    private String passWord;
    private Date createTime;
    private Date updateTime;

    /**
     * 想要MVC框架自动封装，实体类里面就不允许有构造器
     */
//    public User() {
//    }
//    public User(String userName, String passWord) {
//        this.userName = userName;
//        this.passWord = passWord;
//    }

//    public User(String userName, String passWord, Date createTime, Date updateTime) {
//        this.userName = userName;
//        this.passWord = passWord;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

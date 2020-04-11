package com.demo.exception;

/**
 * 自定义的异常类
 * @author Estrella
 * @create 2020-04-11 2:04
 */
public class SysException extends Exception{

    //存储提示信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SysException{" +
                "message='" + message + '\'' +
                '}';
    }
}

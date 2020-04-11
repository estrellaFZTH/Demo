package com.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的拦截器
 * @author Estrella
 * @create 2020-04-11 2:10
 */
public class MyInterceptor1 implements HandlerInterceptor {

    //可不写重写方法。使用接口中的默认方法。
    /**
     * 预处理， controller方法执行前走它
     * return true ： 放行，如果没有，执行controller中的方法。
     * return false ： 不放行，
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了-----前111");
        //不放行，跳转到errorInterceptor页面
        //request.getRequestDispatcher("/WEB-INF/pages/errorInterceptor.jsp").forward(request, response);
        //return false;
        //放行
        return true;
    }

    /**
     * 后处理方法，controller方法执行后，successInterceptor.jsp执行之前走它
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了-----后111");
        //页面跳转，不再走successInterceptor.jsp了，但是successInterceptor.jsp页面会在后台执行。
        //request.getRequestDispatcher("/WEB-INF/pages/errorInterceptor.jsp").forward(request, response);
    }

    /**
     * successInterceptor.jsp页面执行后，该方法会执行。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1执行了-----最后111");
    }
}

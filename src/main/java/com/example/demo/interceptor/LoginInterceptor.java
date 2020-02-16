package com.example.demo.interceptor;

import com.example.demo.util.BrandLoginContextHolder;
import com.example.demo.util.WebHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入controller层之前拦截请求
     * 返回值：表示是否将当前的请求拦截下来  false：拦截请求，请求别终止。true：请求不被拦截，继续执行
     * Object obj:表示被拦的请求的目标对象（controller中方法）
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception 预处理回调方法，实现处理器的预处理（如登录检查）
     *                   返回值：
     *                   true - 表示继续流程（如调用下一个拦截器或处理器)；
     *                   false - 表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("执行到了preHandle方法");
        System.out.println(handler);
        //判断用户是否登录
//        if(request.getSession().getAttribute("session_user") == null){
//
//            response.sendRedirect("userLogin");
//            return false;
//        }
        WebHelper webHelper = getWebHelper(request);
        BrandLoginContextHolder.setLoginBrandInfo(webHelper);
        if(StringUtils.isEmpty(webHelper.getUserName())){
            response.sendRedirect("/logerror?error=106");
            return false;
        }

        return true;
    }

    /**
     * 设置 WebHelper
     * @param request
     * @return
     */
    private WebHelper getWebHelper(HttpServletRequest request) {
        WebHelper webHelper = new WebHelper();
        webHelper.setSex("男");
        webHelper.setUserId(123456789L);
        webHelper.setUserName("测试用户名");
        return webHelper;
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     * 通过ModelAndView参数改变显示的视图，或发往视图的方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），
     * 此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null；
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("执行到了postHandle方法");

        if (modelAndView != null) {
            WebHelper webHelper = BrandLoginContextHolder.getLoginBrandInfo();
            modelAndView.addObject("userId", webHelper.getUserId());
            modelAndView.addObject("userName", webHelper.getUserName());
            modelAndView.addObject("sex", webHelper.getSex());
        }

    }

    /**
     * 视图渲染之后的操作
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BrandLoginContextHolder.removeLoginBrandInfo();
        System.out.println("执行到了afterCompletion方法");
    }

}

package com.piza.filter;

import com.piza.model.UserInfoExample;
import com.piza.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Peter on 16/3/30.
 */
public class LoginInterceptor   extends HandlerInterceptorAdapter {


    private final static ConcurrentMap<String,Long> loginTokenMap=new ConcurrentHashMap<>();

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI=request.getRequestURI();
        if(requestURI.contains("login")){
           return true;
        }
        String token=request.getHeader("token");
        if(token==null){
            response.sendRedirect("/needlogin");
            return false;
        }
        if(loginTokenMap.containsKey(token)){
            loginTokenMap.put(token,System.currentTimeMillis());
            return true;
        }else{
            UserInfoExample example=new UserInfoExample();
            example.or().andCurrentTokenEqualTo(token);
            int count=userInfoService.countByExample(example);
            if(count==1){
                return true;
            }else{
                response.sendRedirect("/needlogin");
                return false;
            }
        }

    }
}

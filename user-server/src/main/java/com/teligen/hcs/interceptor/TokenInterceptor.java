package com.teligen.hcs.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.google.gson.Gson;
import com.teligen.hcs.annotation.SkipTokenVerifiy;
import com.teligen.hcs.exception.MyException;
import com.teligen.hcs.returnFormat.StatusCode;
import com.teligen.hcs.util.token.JwtUtils;
import com.teligen.hcs.util.token.TokenClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Value("${token.close}")
    private boolean close;
    //验证token
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        if(close) return true; //是否关闭token验证，如果关闭，则直接通过
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        //httpServletRequest.getHeader("User-Agent");//浏览器信息

        //object是controller处理器
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有 SkipTokenVerifiy 注解，有则跳过认证
        if (method.isAnnotationPresent(SkipTokenVerifiy.class)) {
            SkipTokenVerifiy passToken = method.getAnnotation(SkipTokenVerifiy.class);
            if (passToken.required()) {
                return true;
            }
        }
        if (token == null) {
            throw new MyException(StatusCode.ERROR,"无token，请重新登录");
        }
        // 验证 token 信息
        try {
            String tokenStr = JwtUtils.validateLogin(token);
            if(StringUtils.isEmpty(tokenStr)) {
                throw new MyException(StatusCode.ERROR, "token验证错误");
            }
            Gson gson = new Gson();
            TokenClass tokenClass = gson.fromJson(tokenStr, TokenClass.class);
            //每次访问都要更新token
            httpServletResponse.setHeader("token", JwtUtils.createJWT(tokenClass.getId().toString(),tokenClass.getUsername()));
        } catch (JWTDecodeException j) {
            throw new MyException(StatusCode.ERROR,"token验证错误");
        }
        return true;
    }
}

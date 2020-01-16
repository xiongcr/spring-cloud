package com.teligen.config;


import com.teligen.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //将token拦截器加入spring容器，为了获取容器中的自定义属性 token.open
    @Bean
    public TokenInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //token验证拦截器
        registry.addInterceptor(getTokenInterceptor())//Token拦截器
                .addPathPatterns("/**")//拦截所有请求
                .excludePathPatterns("/");//对于ip+port的请求放行，自动跳转到首页
    }
}

package pers.lcy.graduationdesign.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.lcy.graduationdesign.interceptor.LoginRequiredInterceptor;
import pers.lcy.graduationdesign.interceptor.PassportInterceptor;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    PassportInterceptor passportInterceptor;

    @Autowired
    LoginRequiredInterceptor loginRequiredInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor).excludePathPatterns("/error");
        registry.addInterceptor(loginRequiredInterceptor).excludePathPatterns("/","/runjavacode","/user/**","/news/**","/error","/login/**","/like","/dislike","/reg/**");
    }
}

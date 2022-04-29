package com.cdivtc.config;

import com.cdivtc.interceptor.ResouresInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan({"com.cdivtc.controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    /*
    * 开启对静态资源的访问
    * */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/admin/",".jsp");
    }

    /*
     * 在拦截器注册类中添加自定义拦截器
     * addPathPatterns()方法设置拦截的路径
     * excludePathPatterns()方法设置不拦截的路径
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ResouresInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**","/img/**");
    }
}

package com.example.exampleinterceptor.configurations;

import com.example.exampleinterceptor.interceptors.APILoggingInterceptor;
import com.example.exampleinterceptor.interceptors.LoggedUserInterceptor;
import com.example.exampleinterceptor.interceptors.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private TestInterceptor testInterceptor;

    @Autowired
    private LoggedUserInterceptor loggedUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
//      WebMvcConfigurer.super.addInterceptors(interceptorRegistry);
        interceptorRegistry.addInterceptor(apiLoggingInterceptor);
        //per ogni interceptor ne aggiungiamo un altro
        interceptorRegistry.addInterceptor(testInterceptor);
        interceptorRegistry.addInterceptor(loggedUserInterceptor);
        //è importante l'ordine in cui vengono inseriti
    }
}

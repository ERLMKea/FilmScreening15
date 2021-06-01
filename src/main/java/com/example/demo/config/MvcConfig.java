package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(
            ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/css/*.css").addResourceLocations("classpath:/static/").setCachePeriod(24 * 3600 * 365);
        registry.addResourceHandler("/static/*.css").addResourceLocations("classpath:/static/").setCachePeriod(0);

    }
}

package com.ssau.lab3.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

@EnableWebMvc
@Configuration
public class XSLTWebConfigurer implements WebMvcConfigurer {
    @Bean
    public XsltViewResolver xsltViewResolver() {
        XsltViewResolver viewResolver = new XsltViewResolver();
        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".xslt");
        return viewResolver;
    }
}

package com.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//404에러 - 정적리소스 css, img, js 경로 설정해 줌
		
		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/static/css/");
		
		registry.addResourceHandler("/images/**")
				.addResourceLocations("classpath:/static/images/");
	}

	
}

package com.douzone.mysite.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileuploadConfig implements WebMvcConfigurer {
	
	/* Multipart Resolver*/
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(52428800);
		multipartResolver.setMaxInMemorySize(52428800);
		multipartResolver.setDefaultEncoding("utf-8");
		
		return multipartResolver;
	}

	/* mvc url-resource mapping */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/upload-images/**").addResourceLocations("file:/Users/awlals/Documents/douzone2023/eclipse/eclipse-workspace/mysite/mysite-uploads/");
	}

	
}

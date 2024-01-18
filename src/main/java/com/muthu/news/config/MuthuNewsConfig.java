package com.muthu.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.muthu.news")
@EnableWebMvc
public class MuthuNewsConfig implements WebMvcConfigurer {

	// This method is to set the view name
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		// Path to the view i.e. the page returned by controller
		v.setPrefix("/WEB-INF/pages/");
		// To specify the extension of the file.
		v.setSuffix(".jsp");
		return v;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/files/");
	}

}

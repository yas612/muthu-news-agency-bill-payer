package com.muthu.news.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.muthu.news")
public class MuthuNewsConfig {
	
	//This method is to set the view name
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		//Path to the view i.e. the page returned by controller
		v.setPrefix("/WEB-INF/pages/");
		//To specify the extension of the file.
		v.setSuffix(".jsp");
		return v;
	}

}

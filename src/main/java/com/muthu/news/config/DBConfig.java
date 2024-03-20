package com.muthu.news.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DBConfig {

	@Value("${muthu.news.db.user}")
	private String user;

	@Value("${muthu.news.db.pass}")
	private String pass;
	
	@Value("${muthu.news.db.url}")
	private String dbURL;

	@Bean(name = "appDataSource")
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		driverManagerDataSource.setUrl(dbURL);
		driverManagerDataSource.setUsername(user);
		driverManagerDataSource.setPassword(pass);
		return driverManagerDataSource;
	}

	@Bean(name = "applicationJdbcTemplate")
	public JdbcTemplate applicationDataConnection() {
		return new JdbcTemplate(dataSource());
	}

}

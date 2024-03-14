package com.muthu.news.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

	@Value("${DB_USER}")
	private String user;

	@Value("${DB_PASS}")
	private String pass;
	
	@Value("${DB_URL}")
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

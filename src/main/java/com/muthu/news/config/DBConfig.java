package com.muthu.news.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
	
	@Bean(name = "appDataSource")
    @Primary
    //@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		 driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		 driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/muthu-news");
		 driverManagerDataSource.setUsername("postgres");
		 driverManagerDataSource.setPassword("yas612");
		 return driverManagerDataSource;
    }

    @Bean(name = "applicationJdbcTemplate")
    public JdbcTemplate applicationDataConnection(){
        return new JdbcTemplate(dataSource());
    } 

}

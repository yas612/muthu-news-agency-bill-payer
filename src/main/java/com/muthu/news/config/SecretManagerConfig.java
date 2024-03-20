package com.muthu.news.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.muthu.news.SecretManager;

@Configuration
@PropertySource("classpath:application.properties")
public class SecretManagerConfig {

	@Value("${muthu.news.key.id}")
	private String key;

	@Value("${muthu.news.key.secret}")
	private String secret;
	
	@Value("${muthu.news.ad}")
	private String adSec;
	
	@Value("${muthu.news.ps}")
	private String adPs;

	@Bean
	public SecretManager manager() {
		return new SecretManager(key, secret, adSec, adPs);

	}

}

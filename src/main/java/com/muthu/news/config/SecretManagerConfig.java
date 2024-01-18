package com.muthu.news.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.muthu.news.SecretManager;

@Configuration
public class SecretManagerConfig {

	@Value("${KEY_ID}")
	private String key;

	@Value("${KEY_SECRET}")
	private String secret;

	@Bean
	public SecretManager manager() {
		return new SecretManager(key, secret);

	}

}

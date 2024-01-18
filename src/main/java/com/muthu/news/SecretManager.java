package com.muthu.news;

public class SecretManager {

	private String key;
	
	private String secret;

	public String getKey() {
		return key;
	}

	public String getSecret() {
		return secret;
	}

	public SecretManager(String key, String secret) {
		super();
		this.key = key;
		this.secret = secret;
	}
	
}

package com.muthu.news;

public class SecretManager {

	private String key;
	
	private String secret;
	
	private String adSec;
	
	private String adPs;

	public String getKey() {
		return key;
	}

	public String getSecret() {
		return secret;
	}
	
	public String getAdSec() {
		return adSec;
	}
	
	public String getAdPs() {
		return adPs;
	}

	public SecretManager(String key, String secret, String adSec, String adPs) {
		super();
		this.key = key;
		this.secret = secret;
		this.adSec = adSec;
		this.adPs = adPs;
	}
	
}

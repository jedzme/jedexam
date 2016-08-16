package com.highrise.exam.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService {
	@Value("${header.authentication}")
	private String authentication;

	@Value("${highrise.hostname}")
	private String hostname;

	private final String AUTHORIZATION_STRING = "Authorization";

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getAUTHORIZATION_STRING() {
		return AUTHORIZATION_STRING;
	}

}

package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class TwitterAccount extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3978507009169968608L;

	@Element(name="location", required=false)
	private String location;
	
	@Element(name="username", required=false)
	private String username;
	
	@Element(name="url", required=false)
	private String url;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class User extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549619043113456191L;

	@Element(name="name", required=false)
	private String name;
	
	@Element(name="email-address", required=false)
	private String emailAddress;
	
	@Element(name="token", required=false)
	private String token;
	
	@Element(name="dropbox", required=false)
	private String dropBox;
	
	@Element(name="created-at", required=false)
	private String createdAt;
	
	@Element(name="updated-at", required=false)
	private String updatedAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDropBox() {
		return dropBox;
	}

	public void setDropBox(String dropBox) {
		this.dropBox = dropBox;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}

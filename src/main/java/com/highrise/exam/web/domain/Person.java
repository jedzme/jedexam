package com.highrise.exam.web.domain;

import java.io.Serializable;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Person extends BaseDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7355699781511384661L;

	@Element(name="title", required=false)
	private String title;
	
	@Element(name="first-name", required=false)
	private String firstName;
	
	@Element(name="last-name", required=false)
	private String lastName;

	@Element(name="background", required=false)
	private String background;
	
	@Element(name="company-name", required=false)
	private String companyName;
	
	@Element(name="linkedin-url", required=false)
	private String linkedinUrl;
	
	@Element(name="avatar_url", required=false)
	private String avatarUrl;
	
	@ElementList(required=false)
	private List<Tag> tags;
	
	@Element(name="contact-data", required=false)
	private ContactData contactData;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public ContactData getContactData() {
		return contactData;
	}

	public void setContactData(ContactData contactData) {
		this.contactData = contactData;
	}	
	
}

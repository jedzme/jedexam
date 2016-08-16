package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class WebAddress extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6188289328091395164L;

	@Element(name="location", required=false)
	private String location;
	
	@Element(name="url", required=false)
	private String url;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}

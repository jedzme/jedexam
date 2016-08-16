package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class PhoneNumber extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4087220634404430106L;

	@Element(name="location", required=false)
	private String location;
	
	@Element(name="number", required=false)
	private String number;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
}

package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class EmailAddress extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1184859464373374697L;

	@Element(name="address", required=false)
	private String address;
	
	@Element(name="location", required=false)
	private String location;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}

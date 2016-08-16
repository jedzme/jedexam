package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class InstantMessenger extends BaseDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4717938674616029082L;	

	@Element(name="location", required=false)
	private String location;
	
	@Element(name="protocol", required=false)
	private String protocol;
	
	@Element(name="address", required=false)
	private String address;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

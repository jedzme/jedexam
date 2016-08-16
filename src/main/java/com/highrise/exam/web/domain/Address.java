package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Address extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8064801049863903178L;

	@Element(name="city", required=false)
	private String city;
	
	@Element(name="country", required=false)
	private String country;
	
	@Element(name="location", required=false)
	private String location;
	
	@Element(name="state", required=false)
	private String state;
	
	@Element(name="street", required=false)
	private String street;
	
	@Element(name="zip", required=false)
	private String zip;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}

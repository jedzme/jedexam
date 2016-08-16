package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Tag extends BaseDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8772985188080730060L;

	@Element(name="name", required=false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

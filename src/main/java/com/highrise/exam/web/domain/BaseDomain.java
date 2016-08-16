package com.highrise.exam.web.domain;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public abstract class BaseDomain implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -469124150445794329L;
	
	@Element(required = true)
    private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}

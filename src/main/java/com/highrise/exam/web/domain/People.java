package com.highrise.exam.web.domain;

import java.io.Serializable;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class People implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3800417878840438524L;
	
	@ElementList(entry="person", inline=true, required=false)
	private List<Person> persons;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}

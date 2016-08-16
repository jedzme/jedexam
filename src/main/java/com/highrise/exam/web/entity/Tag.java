package com.highrise.exam.web.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAG")
public class Tag {
	@Id
	@Column(name="TAG_ID")
	private Long id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TAG_CONTACT", joinColumns = { @JoinColumn(name = "TAG_ID", nullable=false, updatable=false) }, 
		inverseJoinColumns = {@JoinColumn(name="CONTACT_ID", nullable=false, updatable=false)})
	private List<Contact> contacts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}

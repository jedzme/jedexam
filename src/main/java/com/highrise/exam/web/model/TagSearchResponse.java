package com.highrise.exam.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.highrise.exam.web.dto.Tag;

public class TagSearchResponse {
	
	@JsonView
	private String response;
	
	@JsonView
	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	

}

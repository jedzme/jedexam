package com.highrise.exam.web.domain;

import java.io.Serializable;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Tags implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5776981935385761309L;
	
	@ElementList(entry="tag", inline=true, required=false)
	private List<Tag> tags;
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}

package org.lastminute.pojo;

import org.lastminute.pojo.abstracts.AbstractPlainObject;

public class Airport extends AbstractPlainObject<String> {

	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}

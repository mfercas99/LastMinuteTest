package org.lastminute.pojo;

import org.lastminute.pojo.abstracts.AbstractPlainObject;

public class Passenger extends AbstractPlainObject<String>{

	private Double percentage;
	
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}

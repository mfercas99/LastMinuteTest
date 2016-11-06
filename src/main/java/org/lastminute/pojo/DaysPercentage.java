package org.lastminute.pojo;

import org.lastminute.pojo.abstracts.AbstractPlainObject;

public class DaysPercentage extends AbstractPlainObject<Integer> {

	private Integer topDaysRange;
	private Integer minDaysRange;
	private Double percentage;
	
	public Integer getTopDaysRange() {
		return topDaysRange;
	}
	public void setTopDaysRange(Integer topDaysRange) {
		this.topDaysRange = topDaysRange;
	}
	public Integer getMinDaysRange() {
		return minDaysRange;
	}
	public void setMinDaysRange(Integer minDaysRange) {
		this.minDaysRange = minDaysRange;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	

}

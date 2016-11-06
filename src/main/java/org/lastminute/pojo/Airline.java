package org.lastminute.pojo;

import java.math.BigDecimal;

import org.lastminute.pojo.abstracts.AbstractPlainObject;

public class Airline extends AbstractPlainObject<String>
{
	
	private BigDecimal infantPrice;
	private String description;
	
	public BigDecimal getInfantPrice() {
		return infantPrice;
	}
	public void setInfantPrice(BigDecimal infantPrice) {
		this.infantPrice = infantPrice;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}

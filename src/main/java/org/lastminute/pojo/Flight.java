package org.lastminute.pojo;

import java.math.BigDecimal;

import org.lastminute.pojo.abstracts.AbstractPlainObject;

public class Flight extends AbstractPlainObject<String>{
	
	private Airport origin;
	private Airport destination;
	private Airline airline;
	private BigDecimal basePrice;
	
	public Flight(){
	}

	public Airport getOrigin() {
		return origin;
	}
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}

}

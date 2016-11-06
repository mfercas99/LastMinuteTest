package org.lastminute.services.pojo;

import java.math.BigDecimal;

public class ResultItem {

	private String flightCode;
	private BigDecimal totalPrice;

	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public int hashCode(){
		
		int result = 1;
		
		result = result * 17 + (flightCode == null ? 0 : flightCode.hashCode());
		
		result = result * 31 + (totalPrice == null ? 0 : totalPrice.hashCode());

		return result;
		
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o == this) {
			return true;
		}
		
		if((o == null) || (o.getClass() != this.getClass())) {
			return false; 
		}

		ResultItem other = (ResultItem)(o);
		boolean sameFlightCode = (other.getFlightCode() == null && this.getFlightCode() == null
				|| (other.getFlightCode() != null && this.getFlightCode() != null && other.getFlightCode().equals(this.getFlightCode()))
				);
		
		boolean sameTotalPrice = (other.getTotalPrice() == null && this.getTotalPrice() == null
				|| (other.getTotalPrice() != null && this.getTotalPrice() != null && other.getTotalPrice().equals(this.getTotalPrice()))
				);
		
		return sameTotalPrice && sameFlightCode;
		
	}

}

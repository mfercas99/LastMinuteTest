package org.lastminute.dao;


import org.lastminute.dao.abstracts.AbstractDao;
import org.lastminute.pojo.Passenger;

public class PassengerDao extends AbstractDao<Passenger, String>{

	public PassengerDao(){
		super("passenger.csv", ",");
	}

	@Override
	protected Passenger getObjectFromLine(String line) {
		String [] d = line.split(this.getSplitBy());
		Passenger obj = new Passenger();
		obj.setCode(d[0]);
		obj.setPercentage(new Double(d[1]));
		return obj;
	}

	
}

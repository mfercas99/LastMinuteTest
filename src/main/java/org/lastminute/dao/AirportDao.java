package org.lastminute.dao;

import org.lastminute.dao.abstracts.AbstractDao;
import org.lastminute.pojo.Airport;

public class AirportDao extends AbstractDao<Airport, String>{

	public AirportDao(){
		super("airports.csv", ",");
	}


	@Override
	protected Airport getObjectFromLine(String line) {
		String [] d = line.split(this.getSplitBy());
		Airport obj = new Airport();
		obj.setCode(d[0]);
		obj.setDescription(d[1]);
		return obj;
	}

}
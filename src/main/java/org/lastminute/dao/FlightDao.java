package org.lastminute.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.lastminute.dao.abstracts.AbstractDao;
import org.lastminute.pojo.Airport;
import org.lastminute.pojo.Flight;

public class FlightDao extends AbstractDao<Flight, String>{
		
	public FlightDao(){
		super("flights.csv", ",");
	}
	
	public Map<String, Flight> getByOriginDestination(Airport origin, Airport destination) {
		if(this.getRecords() == null){
			return null;
		}
		HashMap<String, Flight> result = new HashMap<String, Flight>();
		Iterator<Entry<String, Flight>> it = this.getRecords().entrySet().iterator();
	    while (it.hasNext()) {
			Map.Entry<String, Flight> pair = it.next();
	        Flight f = (Flight)pair.getValue();
	        if(f.getDestination().getCode().equals(destination.getCode()) && f.getOrigin().getCode().equals(origin.getCode())){
	        	result.put((String) pair.getKey(), f);
	        }
	    }
		return result;
	}

	@Override
	protected Flight getObjectFromLine(String line) {
		String [] d = line.split(this.getSplitBy());
		Flight obj = new Flight();
		AirportDao airportDAO = new AirportDao();
		AirlineDao airlineDAO = new AirlineDao();		
		
		obj.setOrigin(airportDAO.getByCode(d[0]));
		obj.setDestination(airportDAO.getByCode(d[1]));
		obj.setAirline(airlineDAO.getByCode(d[2].substring(0,2)));
		obj.setBasePrice(new BigDecimal(d[3]));
		obj.setCode(d[2]);
		return obj;
	}
	
}
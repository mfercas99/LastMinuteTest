package org.lastminute.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.spi.DirStateFactory.Result;

import org.lastminute.dao.AirportDao;
import org.lastminute.dao.DaysPercentageDao;
import org.lastminute.dao.FlightDao;
import org.lastminute.dao.PassengerDao;
import org.lastminute.pojo.Airport;
import org.lastminute.pojo.Flight;
import org.lastminute.services.interfaces.SearchEngine;
import org.lastminute.services.pojo.ResultItem;
import org.lastminute.services.pojo.SearchResult;

public class BasicSearchEngine implements SearchEngine{
	
	private FlightDao flightDAO = new FlightDao();
	private AirportDao airportDAO = new AirportDao();
	private DaysPercentageDao daysPercentageDAO = new DaysPercentageDao();
	private PassengerDao passengerDAO = new PassengerDao();

	public SearchResult performSearch(Integer numAdults, Integer numChild, Integer numInfant, Integer daysToDeparture,
			String origin, String destination) throws IllegalArgumentException{

		SearchResult searchResult = new SearchResult();
		
		Airport airportOrigin = airportDAO.getByCode(origin);
		Airport airportDestination = airportDAO.getByCode(destination);
	
		Map<String, Flight> flights = flightDAO.getByOriginDestination(airportOrigin, airportDestination);
		if(flights.isEmpty()){
			searchResult.setMessage("No flights found for " + airportOrigin + " -> " + destination);
			return searchResult;
		}

		Double daysPriorPercentage = daysPercentageDAO.getByPriorDays(daysToDeparture).getPercentage()/ 100;
		
		Double adultDiscountper = passengerDAO.getByCode("adult").getPercentage() / 100;
		Double childDiscountper = passengerDAO.getByCode("child").getPercentage() / 100;

		List<ResultItem> result = new ArrayList<ResultItem>();
		
		for(Entry<String, Flight> e : flights.entrySet()){
			
			Flight flight = e.getValue();
			
			BigDecimal basePrice = flight.getBasePrice().multiply(new BigDecimal(daysPriorPercentage));
			
			BigDecimal priceAdults = basePrice.multiply(new BigDecimal(numAdults));
			priceAdults = priceAdults.multiply(new BigDecimal(adultDiscountper));
			
			BigDecimal priceChilds = basePrice.multiply(new BigDecimal(numChild));
			priceChilds = priceChilds.multiply(new BigDecimal(childDiscountper)); 
			
			BigDecimal priceInfants = flight.getAirline().getInfantPrice().multiply(new BigDecimal(numInfant));
			
			BigDecimal totalPrice = priceInfants.add(priceChilds).add(priceAdults);
			
			ResultItem item = new ResultItem();
			item.setFlightCode(flight.getCode());
			item.setTotalPrice(totalPrice.setScale(2, RoundingMode.HALF_UP));
			
			result.add(item);
			
		}
		
		searchResult.setResulList(result);
		
		return searchResult;
		
	}

}
